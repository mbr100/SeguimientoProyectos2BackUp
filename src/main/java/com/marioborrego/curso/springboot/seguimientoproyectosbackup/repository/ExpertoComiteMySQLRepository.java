package com.marioborrego.curso.springboot.seguimientoproyectosbackup.repository;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.ExpertoComiteMySQL;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ExpertoComiteMySQLRepository extends CrudRepository<ExpertoComiteMySQL, String> {
}