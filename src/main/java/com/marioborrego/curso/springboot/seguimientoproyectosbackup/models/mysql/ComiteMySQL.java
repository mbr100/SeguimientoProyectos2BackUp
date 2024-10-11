package com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.firebase.Comite;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "comites")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComiteMySQL {
    @Id
    private String id;
    private String nombre;

    // Relación inversa
    @OneToMany(mappedBy = "coordinadorComite") // Relación inversa
    private List<ProyectoMySQL> proyectos;

    public ComiteMySQL(Comite comite) {
        this.id = comite.getId();
        this.nombre = comite.getNombre();
    }
}
