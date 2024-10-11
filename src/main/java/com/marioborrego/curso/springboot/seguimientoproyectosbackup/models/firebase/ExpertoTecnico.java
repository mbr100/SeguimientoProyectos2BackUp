package com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.firebase;

import lombok.*;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpertoTecnico {
    private String id;
    private String idexperto;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private String telefono;
}