/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.backend.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bryan
 */
@Entity
@Table(name = "ofertaslaborales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OfertaLaboral.findAll", query = "SELECT o FROM OfertaLaboral o"),
    @NamedQuery(name = "OfertaLaboral.findByIdOfertaLaboral", query = "SELECT o FROM OfertaLaboral o WHERE o.idOfertaLaboral = :idOfertaLaboral"),
    @NamedQuery(name = "OfertaLaboral.findByCargo", query = "SELECT o FROM OfertaLaboral o WHERE o.cargo = :cargo"),
    @NamedQuery(name = "OfertaLaboral.findByFechaLimite", query = "SELECT o FROM OfertaLaboral o WHERE o.fechaLimite = :fechaLimite"),
    @NamedQuery(name = "OfertaLaboral.findByUrlCurriculum", query = "SELECT o FROM OfertaLaboral o WHERE o.urlCurriculum = :urlCurriculum"),
    @NamedQuery(name = "OfertaLaboral.findByFechaEntrevista", query = "SELECT o FROM OfertaLaboral o WHERE o.fechaEntrevista = :fechaEntrevista")})
public class OfertaLaboral implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOfertaLaboral")
    private Integer idOfertaLaboral;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cargo")
    private String cargo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaLimite")
    @Temporal(TemporalType.DATE)
    private Date fechaLimite;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "urlCurriculum")
    private String urlCurriculum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaEntrevista")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrevista;
    @JoinColumn(name = "idOferta", referencedColumnName = "idOferta")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Oferta idOferta;

    public OfertaLaboral() {
    }

    public OfertaLaboral(Integer idOfertaLaboral) {
        this.idOfertaLaboral = idOfertaLaboral;
    }

    public OfertaLaboral(Integer idOfertaLaboral, String cargo, Date fechaLimite, String urlCurriculum, Date fechaEntrevista) {
        this.idOfertaLaboral = idOfertaLaboral;
        this.cargo = cargo;
        this.fechaLimite = fechaLimite;
        this.urlCurriculum = urlCurriculum;
        this.fechaEntrevista = fechaEntrevista;
    }

    public Integer getIdOfertaLaboral() {
        return idOfertaLaboral;
    }

    public void setIdOfertaLaboral(Integer idOfertaLaboral) {
        this.idOfertaLaboral = idOfertaLaboral;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getUrlCurriculum() {
        return urlCurriculum;
    }

    public void setUrlCurriculum(String urlCurriculum) {
        this.urlCurriculum = urlCurriculum;
    }

    public Date getFechaEntrevista() {
        return fechaEntrevista;
    }

    public void setFechaEntrevista(Date fechaEntrevista) {
        this.fechaEntrevista = fechaEntrevista;
    }

    public Oferta getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Oferta idOferta) {
        this.idOferta = idOferta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOfertaLaboral != null ? idOfertaLaboral.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfertaLaboral)) {
            return false;
        }
        OfertaLaboral other = (OfertaLaboral) object;
        if ((this.idOfertaLaboral == null && other.idOfertaLaboral != null) || (this.idOfertaLaboral != null && !this.idOfertaLaboral.equals(other.idOfertaLaboral))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gscars.backend.entidades.OfertaLaboral[ idOfertaLaboral=" + idOfertaLaboral + " ]";
    }
    
}
