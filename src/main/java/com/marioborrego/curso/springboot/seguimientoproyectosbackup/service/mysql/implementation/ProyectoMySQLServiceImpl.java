package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.implementation;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.ProyectoMySQL;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.repository.ProyectoMySQLRepository;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.interfaces.ProyectoMySQLService;
import org.springframework.stereotype.Service;

@Service
public class ProyectoMySQLServiceImpl implements ProyectoMySQLService {
    private final ProyectoMySQLRepository proyectoMySQLRepository;

    public ProyectoMySQLServiceImpl(ProyectoMySQLRepository proyectoMySQLRepository) {
        this.proyectoMySQLRepository = proyectoMySQLRepository;
    }

    @Override
    public boolean guardarProyecto(ProyectoMySQL proyecto) {
        try {
            proyectoMySQLRepository.save(proyecto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
