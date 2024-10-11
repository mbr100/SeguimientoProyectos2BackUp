package com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.firebase;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Consultores {
    private String id;
    private String nombre;
    private String email;
    private String telefono;
    private String consultora;
}