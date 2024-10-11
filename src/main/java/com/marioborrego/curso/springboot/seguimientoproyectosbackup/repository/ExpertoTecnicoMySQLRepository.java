package com.marioborrego.curso.springboot.seguimientoproyectosbackup.repository;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.ExpertoTecnicoMySQL;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ExpertoTecnicoMySQLRepository extends CrudRepository<ExpertoTecnicoMySQL, String> {
}