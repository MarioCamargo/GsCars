/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.backend.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
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
@Table(name = "telefonos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefono.findAll", query = "SELECT t FROM Telefono t"),
    @NamedQuery(name = "Telefono.findByIdTelefono", query = "SELECT t FROM Telefono t WHERE t.telefonoPK.idTelefono = :idTelefono"),
    @NamedQuery(name = "Telefono.findByIdUsuario", query = "SELECT t FROM Telefono t WHERE t.telefonoPK.idUsuario = :idUsuario"),
    @NamedQuery(name = "Telefono.findByNumeroTelefono", query = "SELECT t FROM Telefono t WHERE t.numeroTelefono = :numeroTelefono")})
public class Telefono implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TelefonoPK telefonoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numeroTelefono")
    private String numeroTelefono;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;

    public Telefono() {
    }

    public Telefono(TelefonoPK telefonoPK) {
        this.telefonoPK = telefonoPK;
    }

    public Telefono(TelefonoPK telefonoPK, String numeroTelefono) {
        this.telefonoPK = telefonoPK;
        this.numeroTelefono = numeroTelefono;
    }

    public Telefono(int idTelefono, int idUsuario) {
        this.telefonoPK = new TelefonoPK(idTelefono, idUsuario);
    }

    public TelefonoPK getTelefonoPK() {
        return telefonoPK;
    }

    public void setTelefonoPK(TelefonoPK telefonoPK) {
        this.telefonoPK = telefonoPK;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telefonoPK != null ? telefonoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefono)) {
            return false;
        }
        Telefono other = (Telefono) object;
        if ((this.telefonoPK == null && other.telefonoPK != null) || (this.telefonoPK != null && !this.telefonoPK.equals(other.telefonoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gscars.backend.entidades.Telefono[ telefonoPK=" + telefonoPK + " ]";
    }
    
}
