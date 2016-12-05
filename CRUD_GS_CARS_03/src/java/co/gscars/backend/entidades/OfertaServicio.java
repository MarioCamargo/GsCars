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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bryan
 */
@Entity
@Table(name = "ofertaservicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OfertaServicio.findAll", query = "SELECT o FROM OfertaServicio o"),
    @NamedQuery(name = "OfertaServicio.findByIdOfertaServicio", query = "SELECT o FROM OfertaServicio o WHERE o.idOfertaServicio = :idOfertaServicio"),
    @NamedQuery(name = "OfertaServicio.findByDescuento", query = "SELECT o FROM OfertaServicio o WHERE o.descuento = :descuento")})
public class OfertaServicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOfertaServicio")
    private Integer idOfertaServicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento")
    private int descuento;
    @JoinColumn(name = "idServicio", referencedColumnName = "idServicio")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Servicio idServicio;
    @JoinColumn(name = "idOferta", referencedColumnName = "idOferta")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Oferta idOferta;

    public OfertaServicio() {
    }

    public OfertaServicio(Integer idOfertaServicio) {
        this.idOfertaServicio = idOfertaServicio;
    }

    public OfertaServicio(Integer idOfertaServicio, int descuento) {
        this.idOfertaServicio = idOfertaServicio;
        this.descuento = descuento;
    }

    public Integer getIdOfertaServicio() {
        return idOfertaServicio;
    }

    public void setIdOfertaServicio(Integer idOfertaServicio) {
        this.idOfertaServicio = idOfertaServicio;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
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
        hash += (idOfertaServicio != null ? idOfertaServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfertaServicio)) {
            return false;
        }
        OfertaServicio other = (OfertaServicio) object;
        if ((this.idOfertaServicio == null && other.idOfertaServicio != null) || (this.idOfertaServicio != null && !this.idOfertaServicio.equals(other.idOfertaServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gscars.backend.entidades.OfertaServicio[ idOfertaServicio=" + idOfertaServicio + " ]";
    }
    
}
