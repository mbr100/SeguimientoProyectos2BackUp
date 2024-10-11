package com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.firebase;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.ServerTimestamp;
import lombok.*;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tramites {
    private String id;
    private String codigo;
    private String titulo;
    private String cliente;
    private @ServerTimestamp Timestamp fechaInicioTramite;
    private @ServerTimestamp Timestamp fechaFinTramite;
    private @ServerTimestamp Timestamp fechaEntrega;
    private String expertoTecnico;
    private String consultor;
    private String analisis;
    private String estado;
}
