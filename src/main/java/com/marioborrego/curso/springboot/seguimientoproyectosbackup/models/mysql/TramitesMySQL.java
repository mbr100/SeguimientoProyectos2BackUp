package com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.ServerTimestamp;
import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.firebase.Tramites;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "tramites")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TramitesMySQL {
    @Id
    private String id;
    private String titulo;
    private String cliente;
    private @ServerTimestamp Timestamp fechaInicioTramite;
    private @ServerTimestamp Timestamp fechaFinTramite;
    private @ServerTimestamp Timestamp fechaEntrega;
    @ManyToOne
    @JoinColumn(name = "experto_tecnico")
    private ExpertoTecnicoMySQL expertoTecnico;
    @ManyToOne
    @JoinColumn(name = "consultores")
    private ConsultoresMysql consultor;
    @Column(columnDefinition = "TEXT")
    private String analisis;
    private String estado;

    public TramitesMySQL(Tramites tramite, ExpertoTecnicoMySQL expertoTecnico, ConsultoresMysql consultor) {
        this.id = tramite.getId();
        this.titulo = tramite.getTitulo();
        this.cliente = tramite.getCliente();
        this.fechaInicioTramite = tramite.getFechaInicioTramite();
        this.fechaFinTramite = tramite.getFechaFinTramite();
        this.fechaEntrega = tramite.getFechaEntrega();
        this.expertoTecnico = expertoTecnico;
        this.consultor = consultor;
        this.analisis = tramite.getAnalisis();
        this.estado = tramite.getEstado();
    }
}
