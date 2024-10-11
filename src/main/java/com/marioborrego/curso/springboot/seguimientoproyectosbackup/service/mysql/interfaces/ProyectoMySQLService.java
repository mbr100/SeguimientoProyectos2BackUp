package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.interfaces;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.ProyectoMySQL;
import org.springframework.stereotype.Service;

@Service
public interface ProyectoMySQLService {
    boolean guardarProyecto(ProyectoMySQL proyecto);
}
