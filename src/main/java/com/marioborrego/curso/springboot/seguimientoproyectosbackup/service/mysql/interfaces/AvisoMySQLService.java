package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.interfaces;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.AvisoMySQL;
import org.springframework.stereotype.Service;

@Service
public interface AvisoMySQLService {
    void guardarAviso(AvisoMySQL aviso);
}
