package com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.firebase.Recurso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "recurso")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecursoMySQL {
    @Id
    private String id;
    private String tipo;
    @Column(columnDefinition = "TEXT")
    private String contenido;
    @ManyToOne
    @JoinColumn(name = "tipo_recursp")
    private TipoRecursoMySQL tipoProyecto;

    public RecursoMySQL(Recurso recurso, TipoRecursoMySQL tipoRecurso) {
        this.id = recurso.getId();
        this.tipo = recurso.getTipo();
        this.contenido = recurso.getContenido();
        this.tipoProyecto = tipoRecurso;
    }
}
