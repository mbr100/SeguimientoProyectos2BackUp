package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.implementation;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.ExpertoComiteMySQL;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.repository.ExpertoComiteMySQLRepository;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.interfaces.ExpertoComiteMySQLService;
import org.springframework.stereotype.Service;

@Service
public class ExpertoComiteMySQLServiceImpl implements ExpertoComiteMySQLService {
    private final ExpertoComiteMySQLRepository expertoComiteMySQLRepository;

    public ExpertoComiteMySQLServiceImpl(ExpertoComiteMySQLRepository expertoComiteMySQLRepository) {
        this.expertoComiteMySQLRepository = expertoComiteMySQLRepository;
    }
    @Override
    public boolean guardarExpertoComite(ExpertoComiteMySQL expertoComiteMySQL) {
        try {
            expertoComiteMySQLRepository.save(expertoComiteMySQL);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ExpertoComiteMySQL buscarExpertoComitePorId(String experto4D) {
        return expertoComiteMySQLRepository.findById(experto4D).orElse(null);
    }

}
