package com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.firebase;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.ServerTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Proyecto {
    private String id;
    private String codigo;
    private String acronimo;
    private String titulo;
    private String cliente;
    private String ejercicio;
    private @ServerTimestamp Timestamp fechaInicioProyecto;
    private @ServerTimestamp Timestamp fechaFinProyecto;
    private @ServerTimestamp Timestamp fechaComite;
    private @ServerTimestamp Timestamp fechaFinComite;
    private String coordinadorComite;
    private Integer numeroVersionComite;
    private String expertoTecnico;
    private String experto2Tecnico;
    private String experto4D;
    private String experto4D2;
    private String consultor;
    private String estado;
    private Boolean IMV;
    private Integer anoCertificacion;
    private Double precioOfertado;
    private String codigoUnesco;
    private Boolean proyectoPrincipal;
    private String tipoProyecto;

    public void setCodigoUnesco(Object codigoUnesco) {
        this.codigoUnesco = String.valueOf(codigoUnesco);
    }
}
