package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.interfaces;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.ExpertoComiteMySQL;
import org.springframework.stereotype.Service;

@Service
public interface ExpertoComiteMySQLService {
    boolean guardarExpertoComite(ExpertoComiteMySQL expertoComiteMySQL);
    ExpertoComiteMySQL buscarExpertoComitePorId(String experto4D);
}
