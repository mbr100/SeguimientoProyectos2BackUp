package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.implementation;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.ConsultoresMysql;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.repository.ConsultoresMysqlRepository;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.interfaces.ConsultoresMysqlService;
import org.springframework.stereotype.Service;

@Service
public class ConsultoresMysqlServiceImpl implements ConsultoresMysqlService {
    private final ConsultoresMysqlRepository consultoresMysqlRepository;

    public ConsultoresMysqlServiceImpl(ConsultoresMysqlRepository consultoresMysqlRepository) {
        this.consultoresMysqlRepository = consultoresMysqlRepository;
    }
    @Override
    public boolean guardarConsultor(ConsultoresMysql consultores) {
        try {
            consultoresMysqlRepository.save(consultores);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ConsultoresMysql buscarConsultorPorId(String consultor) {
        return consultoresMysqlRepository.findById(consultor).orElse(null);
    }
}
