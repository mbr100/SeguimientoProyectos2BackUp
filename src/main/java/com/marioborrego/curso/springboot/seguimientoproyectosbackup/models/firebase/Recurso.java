package com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.firebase;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recurso {
    private String id;
    private String tipo;
    private String contenido;
    private String tipoProyecto;
}