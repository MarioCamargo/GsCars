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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bryan
 */
@Entity
@Table(name = "prefacturasservicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrefacturaServicio.findAll", query = "SELECT p FROM PrefacturaServicio p"),
    @NamedQuery(name = "PrefacturaServicio.findByIdPreFacturaServicio", query = "SELECT p FROM PrefacturaServicio p WHERE p.idPreFacturaServicio = :idPreFacturaServicio"),
    @NamedQuery(name = "PrefacturaServicio.findByFechaPago", query = "SELECT p FROM PrefacturaServicio p WHERE p.fechaPago = :fechaPago"),
    @NamedQuery(name = "PrefacturaServicio.findByValorServicio", query = "SELECT p FROM PrefacturaServicio p WHERE p.valorServicio = :valorServicio")})
public class PrefacturaServicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPreFacturaServicio")
    private Integer idPreFacturaServicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaPago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorServicio")
    private int valorServicio;
    @JoinColumn(name = "idInspeccion", referencedColumnName = "idInspeccion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Inspeccion idInspeccion;

    public PrefacturaServicio() {
    }

    public PrefacturaServicio(Integer idPreFacturaServicio) {
        this.idPreFacturaServicio = idPreFacturaServicio;
    }

    public PrefacturaServicio(Integer idPreFacturaServicio, Date fechaPago, int valorServicio) {
        this.idPreFacturaServicio = idPreFacturaServicio;
        this.fechaPago = fechaPago;
        this.valorServicio = valorServicio;
    }

    public Integer getIdPreFacturaServicio() {
        return idPreFacturaServicio;
    }

    public void setIdPreFacturaServicio(Integer idPreFacturaServicio) {
        this.idPreFacturaServicio = idPreFacturaServicio;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getValorServicio() {
        return valorServicio;
    }

    public void setValorServicio(int valorServicio) {
        this.valorServicio = valorServicio;
    }

    public Inspeccion getIdInspeccion() {
        return idInspeccion;
    }

    public void setIdInspeccion(Inspeccion idInspeccion) {
        this.idInspeccion = idInspeccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPreFacturaServicio != null ? idPreFacturaServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrefacturaServicio)) {
            return false;
        }
        PrefacturaServicio other = (PrefacturaServicio) object;
        if ((this.idPreFacturaServicio == null && other.idPreFacturaServicio != null) || (this.idPreFacturaServicio != null && !this.idPreFacturaServicio.equals(other.idPreFacturaServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gscars.backend.entidades.PrefacturaServicio[ idPreFacturaServicio=" + idPreFacturaServicio + " ]";
    }
    
}
