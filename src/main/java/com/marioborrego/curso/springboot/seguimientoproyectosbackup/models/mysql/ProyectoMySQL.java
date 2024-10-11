package com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.ServerTimestamp;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.firebase.Proyecto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "proyectos")
public class ProyectoMySQL {
    @Id
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

    @ManyToOne
    @JoinColumn(name = "coordinador_comite")
    private ComiteMySQL coordinadorComite;
    private Integer numeroVersionComite;

    @ManyToOne
    @JoinColumn(name = "experto_tecnico") // clave foránea
    private ExpertoTecnicoMySQL expertoTecnico;
    private String experto2Tecnico;

    @ManyToOne
    @JoinColumn(name = "experto_comite")
    private ExpertoComiteMySQL experto4D;

    private String experto4D2;

    @ManyToOne
    @JoinColumn(name = "consultores")
    private ConsultoresMysql consultor;
    private String estado;
    private Boolean IMV;
    private Integer anoCertificacion;
    private Double precioOfertado;
    private String codigoUnesco;
    private Boolean proyectoPrincipal;
    private String tipoProyecto;

    public ProyectoMySQL(Proyecto proyecto, ComiteMySQL coordinadorComite, ExpertoTecnicoMySQL expertoTecnico, ExpertoComiteMySQL experto4D, ConsultoresMysql consultor) {
        this.id = proyecto.getId();
        this.codigo = proyecto.getCodigo();
        this.acronimo = proyecto.getAcronimo();
        this.titulo = proyecto.getTitulo();
        this.cliente = proyecto.getCliente();
        this.ejercicio = proyecto.getEjercicio();
        this.fechaInicioProyecto = proyecto.getFechaInicioProyecto();
        this.fechaFinProyecto = proyecto.getFechaFinProyecto();
        this.fechaComite = proyecto.getFechaComite();
        this.fechaFinComite = proyecto.getFechaFinComite();
        this.coordinadorComite = coordinadorComite;
        this.numeroVersionComite = proyecto.getNumeroVersionComite();
        this.expertoTecnico = expertoTecnico;
        this.experto2Tecnico = proyecto.getExperto2Tecnico();
        this.experto4D = experto4D;
        this.experto4D2 = proyecto.getExperto4D2();
        this.consultor = consultor;
        this.estado = proyecto.getEstado();
        this.IMV = proyecto.getIMV();
        this.anoCertificacion = proyecto.getAnoCertificacion();
        this.precioOfertado = proyecto.getPrecioOfertado();
        this.codigoUnesco = proyecto.getCodigoUnesco();
        this.proyectoPrincipal = proyecto.getProyectoPrincipal();
        this.tipoProyecto = proyecto.getTipoProyecto();
    }
}
