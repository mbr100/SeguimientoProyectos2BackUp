package com.marioborrego.curso.springboot.seguimientoproyectosbackup.repository;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.ConsultoresMysql;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ConsultoresMysqlRepository extends CrudRepository<ConsultoresMysql, String> {
}