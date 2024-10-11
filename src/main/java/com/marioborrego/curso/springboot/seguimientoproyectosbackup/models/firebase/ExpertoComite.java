package com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.firebase;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter @Setter
public class ExpertoComite {
    private String id;
    private String idexperto;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private String telefono;


}