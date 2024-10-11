package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.interfaces;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.RecursoMySQL;
import org.springframework.stereotype.Service;

@Service
public interface RecursoMySQLService {
    boolean guardarRecurso(RecursoMySQL recurso);
}
