package com.marioborrego.curso.springboot.seguimientoproyectosbackup.repository;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.RecursoMySQL;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RecursoMySQLRepository extends CrudRepository<RecursoMySQL, UUID> {
}