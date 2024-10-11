package com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.mysql;

import com.marioborrego.curso.springboot.seguimientoproyectosbackup.models.firebase.Aviso;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "avisos")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvisoMySQL {
    @Id
    private String id;
    private String idTramite;
    private String fechaFinTramite;
    private int diasRestantes;
    private String mensaje;
    private String tipo;
    private String codigo;
    private String idAviso;

    public AvisoMySQL(Aviso aviso) {
        this.id =aviso.getId();
        this.idTramite = aviso.getIdTramite();
        this.fechaFinTramite = aviso.getFechaFinTrammite().toString();
        this.diasRestantes = aviso.getDiasRestantes();
        this.mensaje = aviso.getMensaje();
        this.tipo = aviso.getTipo();
        this.codigo = aviso.getCodigo();
        this.idAviso = aviso.getIdAviso();
    }
}
