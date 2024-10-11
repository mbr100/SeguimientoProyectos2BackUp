package com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.firebase.ExpertoComite;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "expertoComite")
public class ExpertoComiteMySQL {
    @Id
    private String id;
    private String idexperto;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private String telefono;

    // Relación inversa
    @OneToMany(mappedBy = "experto4D")
    private List<ProyectoMySQL> proyectos;

    public ExpertoComiteMySQL(ExpertoComite expertoComite) {
        this.id = expertoComite.getId();
        this.idexperto = expertoComite.getId();
        this.nombre = expertoComite.getNombre();
        this.apellido1 = expertoComite.getApellido1();
        this.apellido2 = expertoComite.getApellido2();
        this.email = expertoComite.getEmail();
        this.telefono = expertoComite.getTelefono();
    }
}
