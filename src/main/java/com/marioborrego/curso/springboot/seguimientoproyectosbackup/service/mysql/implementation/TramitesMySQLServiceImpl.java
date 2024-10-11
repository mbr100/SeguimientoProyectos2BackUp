package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.implementation;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.TramitesMySQL;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.repository.TramitesMySQLRepository;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.interfaces.TramitesMySQLService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TramitesMySQLServiceImpl implements TramitesMySQLService {
    private final TramitesMySQLRepository tramitesMySQLRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(TramitesMySQLServiceImpl.class);

    public TramitesMySQLServiceImpl(TramitesMySQLRepository tramitesMySQLRepository) {
        this.tramitesMySQLRepository = tramitesMySQLRepository;
    }

    @Override
    public boolean guardarTramite(TramitesMySQL tramite) {
        try {
            tramitesMySQLRepository.save(tramite);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
