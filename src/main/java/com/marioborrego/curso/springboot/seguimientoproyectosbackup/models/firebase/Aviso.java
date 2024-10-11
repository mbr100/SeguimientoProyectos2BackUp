package com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.firebase;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Aviso {
    private String id;
    private String idTramite;
    private Date fechaFinTrammite;
    private int diasRestantes;
    private String mensaje;
    private String tipo;
    private String codigo;
    private String idAviso;
}
