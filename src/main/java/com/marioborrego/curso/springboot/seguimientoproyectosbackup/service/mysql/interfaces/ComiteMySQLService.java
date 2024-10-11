package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.interfaces;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.ComiteMySQL;
import org.springframework.stereotype.Service;

@Service
public interface ComiteMySQLService {
    boolean guardarComite(ComiteMySQL comite);
    ComiteMySQL obtenerComitePorId(String id);
}
