package com.marioborrego.curso.springboot.seguimientoproyectosbackup.repository;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.TipoRecursoMySQL;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TipoRecursoMySQLRepository extends CrudRepository<TipoRecursoMySQL, String> {
    TipoRecursoMySQL findTipoRecursoMySQLSByTipoRecursp(String nombre);
}