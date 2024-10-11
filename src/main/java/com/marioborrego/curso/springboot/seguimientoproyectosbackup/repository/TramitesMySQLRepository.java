package com.marioborrego.curso.springboot.seguimientoproyectosbackup.repository;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.TramitesMySQL;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TramitesMySQLRepository extends CrudRepository<TramitesMySQL, UUID> {
}