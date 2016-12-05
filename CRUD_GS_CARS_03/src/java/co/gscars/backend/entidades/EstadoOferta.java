/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.backend.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bryan
 */
@Entity
@Table(name = "estadoofertas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoOferta.findAll", query = "SELECT e FROM EstadoOferta e"),
    @NamedQuery(name = "EstadoOferta.findByIdEstadoOferta", query = "SELECT e FROM EstadoOferta e WHERE e.idEstadoOferta = :idEstadoOferta"),
    @NamedQuery(name = "EstadoOferta.findByEstado", query = "SELECT e FROM EstadoOferta e WHERE e.estado = :estado")})
public class EstadoOferta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstadoOferta")
    private Integer idEstadoOferta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estado")
    private String estado;
    @OneToMany(mappedBy = "idEstadoOferta", fetch = FetchType.LAZY)
    private List<Oferta> ofertaList;

    public EstadoOferta() {
    }

    public EstadoOferta(Integer idEstadoOferta) {
        this.idEstadoOferta = idEstadoOferta;
    }

    public EstadoOferta(Integer idEstadoOferta, String estado) {
        this.idEstadoOferta = idEstadoOferta;
        this.estado = estado;
    }

    public Integer getIdEstadoOferta() {
        return idEstadoOferta;
    }

    public void setIdEstadoOferta(Integer idEstadoOferta) {
        this.idEstadoOferta = idEstadoOferta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Oferta> getOfertaList() {
        return ofertaList;
    }

    public void setOfertaList(List<Oferta> ofertaList) {
        this.ofertaList = ofertaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoOferta != null ? idEstadoOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoOferta)) {
            return false;
        }
        EstadoOferta other = (EstadoOferta) object;
        if ((this.idEstadoOferta == null && other.idEstadoOferta != null) || (this.idEstadoOferta != null && !this.idEstadoOferta.equals(other.idEstadoOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gscars.backend.entidades.EstadoOferta[ idEstadoOferta=" + idEstadoOferta + " ]";
    }
    
}
