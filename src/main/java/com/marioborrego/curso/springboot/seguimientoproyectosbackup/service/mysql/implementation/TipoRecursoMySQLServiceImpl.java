package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.implementation;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.TipoRecursoMySQL;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.repository.TipoRecursoMySQLRepository;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.interfaces.TipoRecursoMySQLService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TipoRecursoMySQLServiceImpl implements TipoRecursoMySQLService {
    private final TipoRecursoMySQLRepository tipoRecursoMySQLRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(TipoRecursoMySQLServiceImpl.class);

    public TipoRecursoMySQLServiceImpl(TipoRecursoMySQLRepository tipoRecursoMySQLRepository) {
        this.tipoRecursoMySQLRepository = tipoRecursoMySQLRepository;
    }

    @Override
    public boolean guardarTipoRecurso(TipoRecursoMySQL tipoRecurso) {
        try {
            tipoRecursoMySQLRepository.save(tipoRecurso);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public TipoRecursoMySQL buscarTipoRecursoPorId(String id) {
        return tipoRecursoMySQLRepository.findById(id).orElse(null);
    }

    @Override
    public TipoRecursoMySQL buscarTipoRecursoPorNombre(String nombre) {
        return tipoRecursoMySQLRepository.findTipoRecursoMySQLSByTipoRecursp(nombre);
    }
}
