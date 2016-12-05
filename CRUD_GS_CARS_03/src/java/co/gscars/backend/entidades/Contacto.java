/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.backend.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bryan
 */
@Entity
@Table(name = "contactenos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacto.findAll", query = "SELECT c FROM Contacto c"),
    @NamedQuery(name = "Contacto.findByIdContactenos", query = "SELECT c FROM Contacto c WHERE c.idContactenos = :idContactenos"),
    @NamedQuery(name = "Contacto.findByNombreContacto", query = "SELECT c FROM Contacto c WHERE c.nombreContacto = :nombreContacto"),
    @NamedQuery(name = "Contacto.findByCorreoElectronico", query = "SELECT c FROM Contacto c WHERE c.correoElectronico = :correoElectronico")})
public class Contacto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idContactenos")
    private Integer idContactenos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreContacto")
    private String nombreContacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correoElectronico")
    private String correoElectronico;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "mensaje")
    private String mensaje;
    @JoinColumn(name = "idAdministrador", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idAdministrador;

    public Contacto() {
    }

    public Contacto(Integer idContactenos) {
        this.idContactenos = idContactenos;
    }

    public Contacto(Integer idContactenos, String nombreContacto, String correoElectronico, String mensaje) {
        this.idContactenos = idContactenos;
        this.nombreContacto = nombreContacto;
        this.correoElectronico = correoElectronico;
        this.mensaje = mensaje;
    }

    public Integer getIdContactenos() {
        return idContactenos;
    }

    public void setIdContactenos(Integer idContactenos) {
        this.idContactenos = idContactenos;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Usuario getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Usuario idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContactenos != null ? idContactenos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacto)) {
            return false;
        }
        Contacto other = (Contacto) object;
        if ((this.idContactenos == null && other.idContactenos != null) || (this.idContactenos != null && !this.idContactenos.equals(other.idContactenos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gscars.backend.entidades.Contacto[ idContactenos=" + idContactenos + " ]";
    }
    
}
