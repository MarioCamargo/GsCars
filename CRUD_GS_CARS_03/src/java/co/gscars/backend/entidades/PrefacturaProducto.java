/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.backend.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bryan
 */
@Entity
@Table(name = "prefacturasproductos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrefacturaProducto.findAll", query = "SELECT p FROM PrefacturaProducto p"),
    @NamedQuery(name = "PrefacturaProducto.findByIdPreFacturaProducto", query = "SELECT p FROM PrefacturaProducto p WHERE p.idPreFacturaProducto = :idPreFacturaProducto"),
    @NamedQuery(name = "PrefacturaProducto.findByFechaVenta", query = "SELECT p FROM PrefacturaProducto p WHERE p.fechaVenta = :fechaVenta")})
public class PrefacturaProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPreFacturaProducto")
    private Integer idPreFacturaProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaVenta")
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    @JoinColumn(name = "idCliente", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prefacturaProducto", fetch = FetchType.LAZY)
    private List<DetallePrefactura> detallePrefacturaList;

    public PrefacturaProducto() {
    }

    public PrefacturaProducto(Integer idPreFacturaProducto) {
        this.idPreFacturaProducto = idPreFacturaProducto;
    }

    public PrefacturaProducto(Integer idPreFacturaProducto, Date fechaVenta) {
        this.idPreFacturaProducto = idPreFacturaProducto;
        this.fechaVenta = fechaVenta;
    }

    public Integer getIdPreFacturaProducto() {
        return idPreFacturaProducto;
    }

    public void setIdPreFacturaProducto(Integer idPreFacturaProducto) {
        this.idPreFacturaProducto = idPreFacturaProducto;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Usuario getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Usuario idCliente) {
        this.idCliente = idCliente;
    }

    @XmlTransient
    public List<DetallePrefactura> getDetallePrefacturaList() {
        return detallePrefacturaList;
    }

    public void setDetallePrefacturaList(List<DetallePrefactura> detallePrefacturaList) {
        this.detallePrefacturaList = detallePrefacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPreFacturaProducto != null ? idPreFacturaProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrefacturaProducto)) {
            return false;
        }
        PrefacturaProducto other = (PrefacturaProducto) object;
        if ((this.idPreFacturaProducto == null && other.idPreFacturaProducto != null) || (this.idPreFacturaProducto != null && !this.idPreFacturaProducto.equals(other.idPreFacturaProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gscars.backend.entidades.PrefacturaProducto[ idPreFacturaProducto=" + idPreFacturaProducto + " ]";
    }
    
}
