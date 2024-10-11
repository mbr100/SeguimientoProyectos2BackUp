package com.marioborrego.curso.springboot.seguimientoproyectosbackup.repository;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.ProyectoMySQL;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProyectoMySQLRepository extends CrudRepository<ProyectoMySQL, UUID> {
}