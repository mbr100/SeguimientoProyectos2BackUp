package com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.firebase.ExpertoTecnico;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "expertosTecnicos")
public class ExpertoTecnicoMySQL {
    @Id
    private String id;
    private String idexperto;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private String telefono;

    @OneToMany(mappedBy = "expertoTecnico") // Relación inversa
    private List<ProyectoMySQL> proyectos;

    @OneToMany(mappedBy = "expertoTecnico") // Relación inversa
    private List<TramitesMySQL> tramites;

    public ExpertoTecnicoMySQL(ExpertoTecnico expertoTecnico) {
        this.id = expertoTecnico.getId();
        this.idexperto = expertoTecnico.getId();
        this.nombre = expertoTecnico.getNombre();
        this.apellido1 = expertoTecnico.getApellido1();
        this.apellido2 = expertoTecnico.getApellido2();
        this.email = expertoTecnico.getEmail();
        this.telefono = expertoTecnico.getTelefono();
    }
}
