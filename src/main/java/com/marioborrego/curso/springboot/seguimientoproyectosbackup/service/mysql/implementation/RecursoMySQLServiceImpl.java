package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.implementation;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.RecursoMySQL;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.repository.RecursoMySQLRepository;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.interfaces.RecursoMySQLService;
import org.springframework.stereotype.Service;

@Service
public class RecursoMySQLServiceImpl implements RecursoMySQLService {
    private final RecursoMySQLRepository recursoMySQLRepository;

    public RecursoMySQLServiceImpl(RecursoMySQLRepository recursoMySQLRepository) {
        this.recursoMySQLRepository = recursoMySQLRepository;
    }

    @Override
    public boolean guardarRecurso(RecursoMySQL recurso) {
        try {
            recursoMySQLRepository.save(recurso);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
