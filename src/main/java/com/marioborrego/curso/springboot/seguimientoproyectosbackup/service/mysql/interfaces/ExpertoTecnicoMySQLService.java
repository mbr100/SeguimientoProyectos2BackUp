package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.interfaces;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.ExpertoTecnicoMySQL;
import org.springframework.stereotype.Service;

@Service
public interface ExpertoTecnicoMySQLService {
    boolean guardarExpertoTecnico(ExpertoTecnicoMySQL expertoTecnico);
    ExpertoTecnicoMySQL buscarExpertoTecnicoPorId(String id);
}
