package com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.firebase.TipoRecurso;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "tiporecurso")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoRecursoMySQL {
    @Id
    private String id;
    private String tipoRecursp;

    @OneToMany(mappedBy = "tipo")
    private List<RecursoMySQL> recursos;

    public TipoRecursoMySQL(TipoRecurso tipoRecurso) {
        this.id = tipoRecurso.getId();
        this.tipoRecursp = tipoRecurso.getTipoRecursp();
    }
}
