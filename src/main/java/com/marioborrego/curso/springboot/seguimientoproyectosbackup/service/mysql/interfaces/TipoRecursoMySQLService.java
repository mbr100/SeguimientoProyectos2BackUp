package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.interfaces;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.TipoRecursoMySQL;
import org.springframework.stereotype.Service;

@Service
public interface TipoRecursoMySQLService {
    boolean guardarTipoRecurso(TipoRecursoMySQL tipoRecurso);
    TipoRecursoMySQL buscarTipoRecursoPorId(String id);
    TipoRecursoMySQL buscarTipoRecursoPorNombre(String nombre);
}
