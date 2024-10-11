package com.marioborrego.curso.springboot.seguimientoproyectosbackup.service.mysql.interfaces;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql.ConsultoresMysql;
import org.springframework.stereotype.Service;

@Service
public interface ConsultoresMysqlService {
    boolean guardarConsultor(ConsultoresMysql consultores);
    ConsultoresMysql buscarConsultorPorId(String consultor);
}
