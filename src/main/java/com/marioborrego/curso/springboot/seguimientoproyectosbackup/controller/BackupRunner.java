package com.marioborrego.curso.springboot.seguimientoproyectosbackup.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.*;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.firebase.*;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.interfaces.*;
import me.tongfei.progressbar.ProgressBar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;

@Component
public class BackupRunner implements CommandLineRunner {
    private final AvisoService avisosService;
    private final ProyectoService proyectoService;
    private final ComiteService comiteService;
    private final ConsultoresService consultoresService;
    private final ExpertoComiteService expertoComiteService;
    private final ExpertoTecnicoService expertoTecnicoService;
    private final RecursoService recursoService;
    private final TipoRecursoService tipoRecursoService;
    private final TramitesService tramitesService;

    private final AvisoMySQLService avisoMySQLService;
    private final ComiteMySQLService comiteMySQLService;
    private final ConsultoresMysqlService consultoresMysqlService;
    private final ExpertoComiteMySQLService expertoComiteMySQLService;
    private final ExpertoTecnicoMySQLService expertoTecnicoMySQLService;
    private final ProyectoMySQLService proyectosMySQLService;
    private final TipoRecursoMySQLService tipoRecursoMySQLService;
    private final RecursoMySQLService recursoMySQLService;
    private final TramitesMySQLService tramitesMySQLService;

    private static final Logger LOGGER = LoggerFactory.getLogger(BackupRunner.class);
    private final ObjectMapper objectMapper = new ObjectMapper(); // Inicialización única
    private final String[] keys = {"avisos", "proyectos", "comites", "consultores", "expertosComite", "expertosTecnicos", "recursos", "tipoRecursos", "tramites"};


    public BackupRunner(AvisoService avisosService, ProyectoService proyectoService, ComiteService comiteService, ConsultoresService consultoresService,
                        ExpertoComiteService expertoComiteService, ExpertoTecnicoService expertoTecnicoService, RecursoService recursoService,
                        TipoRecursoService tipoRecursoService, TramitesService tramitesService, AvisoMySQLService avisoMySQLService,
                        ComiteMySQLService comiteMySQLService, ConsultoresMysqlService consultoresMysqlServiceImpl, ExpertoComiteMySQLService expertoComiteMySQLService,
                        ExpertoTecnicoMySQLService expertoTecnicoMySQLService, @Qualifier("proyectoMySQLServiceImpl") ProyectoMySQLService proyectosMySQLService,
                        TipoRecursoMySQLService tipoRecursoMySQLService, RecursoMySQLService recursoMySQLService, TramitesMySQLService tramitesMySQLService) {
        this.avisosService = avisosService;
        this.proyectoService = proyectoService;
        this.comiteService = comiteService;
        this.consultoresService = consultoresService;
        this.expertoComiteService = expertoComiteService;
        this.expertoTecnicoService = expertoTecnicoService;
        this.recursoService = recursoService;
        this.tipoRecursoService = tipoRecursoService;
        this.tramitesService = tramitesService;
        this.avisoMySQLService = avisoMySQLService;
        this.comiteMySQLService = comiteMySQLService;
        this.consultoresMysqlService = consultoresMysqlServiceImpl;
        this.expertoComiteMySQLService = expertoComiteMySQLService;
        this.expertoTecnicoMySQLService = expertoTecnicoMySQLService;
        this.proyectosMySQLService = proyectosMySQLService;
        this.tipoRecursoMySQLService = tipoRecursoMySQLService;
        this.recursoMySQLService = recursoMySQLService;
        this.tramitesMySQLService = tramitesMySQLService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
           this.mostrarMenu();
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    generateBackup();
                    break;
                case 2:
                    generateBackupEnMySQL();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
            System.out.println();
        } while (option != 3);
        System.exit(0);
    }

    private void mostrarMenu() {
        System.out.println("=== Menú Principal ===");
        System.out.println("1. Opción 1: Generar Backup");
        System.out.println("2. Opción 2: Generar Backup en MySQL");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }


    private void generateBackup() throws ExecutionException, InterruptedException {
        LOGGER.info("Generando backup de la base de datos");
        Map<String, Object> data = new HashMap<>();

        // Obtener datos en paralelo
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try (ProgressBar progressBar = new ProgressBar("Progreso de Obtención de datos", 10)) {
                List<Runnable> tasks = List.of(
                        () -> {
                            try {
                                data.put(keys[0], avisosService.getAvisos());
                            } catch (ExecutionException | InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        },
                        () -> {
                            try {
                                data.put(keys[1], proyectoService.getProyectos());
                            } catch (ExecutionException | InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        },
                        () -> {
                            try {
                                data.put(keys[2], comiteService.getComites());
                            } catch (ExecutionException | InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        },
                        () -> {
                            try {
                                data.put(keys[3], consultoresService.getConsultores());
                            } catch (ExecutionException | InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        },
                        () -> {
                            try {
                                data.put(keys[4], expertoComiteService.getExpertosComite());
                            } catch (ExecutionException | InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        },
                        () -> {
                            try {
                                data.put(keys[5], expertoTecnicoService.getExpertosTecnicos());
                            } catch (ExecutionException | InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        },
                        () -> {
                            try {
                                data.put(keys[6], recursoService.getRecursos());
                            } catch (ExecutionException | InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        },
                        () -> {
                            try {
                                data.put(keys[7], tipoRecursoService.getTipoRecursos());
                            } catch (ExecutionException | InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        },
                        () -> {
                            try {
                                data.put(keys[8], tramitesService.getTramites());
                            } catch (ExecutionException | InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );

                for (int i = 0; i < tasks.size(); i++) {
                    tasks.get(i).run();
                    progressBar.stepTo(i + 1);
                }
                LOGGER.info("Datos obtenidos");
            } catch (RuntimeException e) {
                LOGGER.error("Error al obtener datos: ", e);
            }
        });

        future.get();

        // Escritura en archivo
        try (ProgressBar progressBar2 = new ProgressBar("Progreso de Escritura de Archivo", 4)) {
            LOGGER.info("Empezando Escritura de backup en archivo");
            progressBar2.stepTo(1);
            String json = objectMapper.writeValueAsString(data);
            progressBar2.stepTo(2);
            Files.write(new File("backup.json").toPath(), json.getBytes());
            progressBar2.stepTo(4);
            LOGGER.info("Backup completado");
        } catch (IOException e) {
            LOGGER.error("Error al escribir el backup: ", e);
        }
    }


    private void generateBackupEnMySQL() throws ExecutionException, InterruptedException {
        insertarConProgreso(keys[0], avisosService.getAvisos(), avisoMySQLService::guardarAviso, AvisoMySQL::new);
        insertarConProgreso(keys[2], comiteService.getComites(), comiteMySQLService::guardarComite, ComiteMySQL::new);
        insertarConProgreso(keys[3], consultoresService.getConsultores(), consultoresMysqlService::guardarConsultor, ConsultoresMysql::new);
        insertarConProgreso(keys[4], expertoComiteService.getExpertosComite(), expertoComiteMySQLService::guardarExpertoComite, ExpertoComiteMySQL::new);
        insertarConProgreso(keys[5], expertoTecnicoService.getExpertosTecnicos(), expertoTecnicoMySQLService::guardarExpertoTecnico, ExpertoTecnicoMySQL::new);
        insertarConProgreso(keys[7], tipoRecursoService.getTipoRecursos(), tipoRecursoMySQLService::guardarTipoRecurso, TipoRecursoMySQL::new);

        insertarConProgreso(keys[1], proyectoService.getProyectos(), proyectosMySQLService::guardarProyecto, proyecto -> {
            ComiteMySQL coordinador = proyecto.getCoordinadorComite() != null ? comiteMySQLService.obtenerComitePorId(proyecto.getCoordinadorComite()) : null;
            ExpertoTecnicoMySQL expertoTecnico = proyecto.getExpertoTecnico() != null ? expertoTecnicoMySQLService.buscarExpertoTecnicoPorId(proyecto.getExpertoTecnico()) : null;
            ExpertoComiteMySQL experto4D = proyecto.getExperto4D() != null ? expertoComiteMySQLService.buscarExpertoComitePorId(proyecto.getExperto4D()) : null;
            ConsultoresMysql consultor = proyecto.getConsultor() != null ? consultoresMysqlService.buscarConsultorPorId(proyecto.getConsultor()) : null;
            return new ProyectoMySQL(proyecto, coordinador, expertoTecnico, experto4D, consultor);
        });
        insertarConProgreso(keys[6], recursoService.getRecursos(), recursoMySQLService::guardarRecurso, recurso -> {
            TipoRecursoMySQL tipoRecurso = recurso.getTipo() != null ? tipoRecursoMySQLService.buscarTipoRecursoPorNombre(recurso.getTipoProyecto()) : null;
            return new RecursoMySQL(recurso, tipoRecurso);
        });
        insertarConProgreso(keys[8], tramitesService.getTramites(), tramitesMySQLService::guardarTramite, tramite -> { // Mapeo de Tramites a TramitesMySQL
                    ExpertoTecnicoMySQL expertoTecnico = tramite.getExpertoTecnico() != null ? expertoTecnicoMySQLService.buscarExpertoTecnicoPorId(tramite.getExpertoTecnico()) : null;
                    ConsultoresMysql consultor = tramite.getConsultor() != null ? consultoresMysqlService.buscarConsultorPorId(tramite.getConsultor()) : null;
                    return new TramitesMySQL(tramite, expertoTecnico, consultor);
                }
        );
    }


    private <T, U> void insertarConProgreso(String entidad, List<T> listaFirestore, Consumer<U> guardar, Function<T, U> mapper) {
        int total = listaFirestore.size();
        if (!listaFirestore.isEmpty()) {
            try (ProgressBar progressBar = new ProgressBar("Progreso de inserción de " + entidad + ": ", total)) {
                listaFirestore.forEach(item -> {
                    guardar.accept(mapper.apply(item));
                    progressBar.step();
                });
            }
        }
    }
}
