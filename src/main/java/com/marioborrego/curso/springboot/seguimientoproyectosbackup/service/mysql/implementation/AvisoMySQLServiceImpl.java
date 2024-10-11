package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.implementation;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.AvisoMySQL;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.repository.AvisoMySQLRepository;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.interfaces.AvisoMySQLService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AvisoMySQLServiceImpl implements AvisoMySQLService {
    private final AvisoMySQLRepository avisoMySQLRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(AvisoMySQLServiceImpl.class);

    public AvisoMySQLServiceImpl(AvisoMySQLRepository avisoMySQLRepository) {
        this.avisoMySQLRepository = avisoMySQLRepository;
    }

    @Override
    public void guardarAviso(AvisoMySQL aviso) {
        try {
            avisoMySQLRepository.save(aviso);
        } catch (Exception e) {
           LOGGER.error("Error al guardar el aviso en MySQL", e);
        }
    }
}
