package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.interfaces;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.TramitesMySQL;
import org.springframework.stereotype.Service;

@Service
public interface TramitesMySQLService {
    boolean guardarTramite(TramitesMySQL tramite);
}
