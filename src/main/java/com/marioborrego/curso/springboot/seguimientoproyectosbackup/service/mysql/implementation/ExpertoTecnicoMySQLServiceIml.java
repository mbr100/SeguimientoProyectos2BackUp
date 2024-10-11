package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.implementation;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.ExpertoTecnicoMySQL;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.repository.ExpertoTecnicoMySQLRepository;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.interfaces.ExpertoTecnicoMySQLService;
import org.springframework.stereotype.Service;

@Service
public class ExpertoTecnicoMySQLServiceIml implements ExpertoTecnicoMySQLService {
    private final ExpertoTecnicoMySQLRepository expertoTecnicoMySQLRepository;

    public ExpertoTecnicoMySQLServiceIml(ExpertoTecnicoMySQLRepository expertoTecnicoMySQLRepository) {
        this.expertoTecnicoMySQLRepository = expertoTecnicoMySQLRepository;
    }

    @Override
    public boolean guardarExpertoTecnico(ExpertoTecnicoMySQL expertoTecnico) {
        try {
            expertoTecnicoMySQLRepository.save(expertoTecnico);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ExpertoTecnicoMySQL buscarExpertoTecnicoPorId(String id) {
        return expertoTecnicoMySQLRepository.findById(id).orElse(null);
    }
}
