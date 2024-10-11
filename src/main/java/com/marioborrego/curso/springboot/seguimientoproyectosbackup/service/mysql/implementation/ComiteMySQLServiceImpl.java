package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.implementation;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.ComiteMySQL;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.repository.ComiteMySQLRepository;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.interfaces.ComiteMySQLService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class ComiteMySQLServiceImpl implements ComiteMySQLService {
    private final ComiteMySQLRepository comiteMySQLRepository;
    private final Logger log = LoggerFactory.getLogger(ComiteMySQLServiceImpl.class);

    public ComiteMySQLServiceImpl(ComiteMySQLRepository comiteMySQLRepository) {
        this.comiteMySQLRepository = comiteMySQLRepository;
    }

    @Override
    public boolean guardarComite(ComiteMySQL comite) {
        try {
            comiteMySQLRepository.save(comite);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ComiteMySQL obtenerComitePorId(String id) {
        return comiteMySQLRepository.findById(id).orElse(null);
    }
}
