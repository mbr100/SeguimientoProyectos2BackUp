package com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.firebase.Consultores;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "consultores")
public class ConsultoresMysql {
    @Id
    private String id;
    private String nombre;
    private String email;
    private String telefono;
    private String consultora;

    @OneToMany(mappedBy = "consultor")
    private List<ProyectoMySQL> proyectos;

    @OneToMany(mappedBy = "consultor")
    private List<TramitesMySQL> tramites;

    public ConsultoresMysql(Consultores consultores) {
        this.id = consultores.getId();
        this.nombre = consultores.getNombre();
        this.email = consultores.getEmail();
        this.telefono = consultores.getTelefono();
        this.consultora = consultores.getConsultora();
    }
}
