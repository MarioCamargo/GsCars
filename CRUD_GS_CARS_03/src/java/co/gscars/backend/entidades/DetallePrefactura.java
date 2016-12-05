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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bryan
 */
@Entity
@Table(name = "detallesprefactura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallePrefactura.findAll", query = "SELECT d FROM DetallePrefactura d"),
    @NamedQuery(name = "DetallePrefactura.findByIdPreFacturaProducto", query = "SELECT d FROM DetallePrefactura d WHERE d.detallePrefacturaPK.idPreFacturaProducto = :idPreFacturaProducto"),
    @NamedQuery(name = "DetallePrefactura.findByIdProducto", query = "SELECT d FROM DetallePrefactura d WHERE d.detallePrefacturaPK.idProducto = :idProducto"),
    @NamedQuery(name = "DetallePrefactura.findByCantidad", query = "SELECT d FROM DetallePrefactura d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetallePrefactura.findByPrecioUnitario", query = "SELECT d FROM DetallePrefactura d WHERE d.precioUnitario = :precioUnitario")})
public class DetallePrefactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallePrefacturaPK detallePrefacturaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioUnitario")
    private int precioUnitario;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto producto;
    @JoinColumn(name = "idPreFacturaProducto", referencedColumnName = "idPreFacturaProducto", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PrefacturaProducto prefacturaProducto;

    public DetallePrefactura() {
    }

    public DetallePrefactura(DetallePrefacturaPK detallePrefacturaPK) {
        this.detallePrefacturaPK = detallePrefacturaPK;
    }

    public DetallePrefactura(DetallePrefacturaPK detallePrefacturaPK, int cantidad, int precioUnitario) {
        this.detallePrefacturaPK = detallePrefacturaPK;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public DetallePrefactura(int idPreFacturaProducto, int idProducto) {
        this.detallePrefacturaPK = new DetallePrefacturaPK(idPreFacturaProducto, idProducto);
    }

    public DetallePrefacturaPK getDetallePrefacturaPK() {
        return detallePrefacturaPK;
    }

    public void setDetallePrefacturaPK(DetallePrefacturaPK detallePrefacturaPK) {
        this.detallePrefacturaPK = detallePrefacturaPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public PrefacturaProducto getPrefacturaProducto() {
        return prefacturaProducto;
    }

    public void setPrefacturaProducto(PrefacturaProducto prefacturaProducto) {
        this.prefacturaProducto = prefacturaProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallePrefacturaPK != null ? detallePrefacturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePrefactura)) {
            return false;
        }
        DetallePrefactura other = (DetallePrefactura) object;
        if ((this.detallePrefacturaPK == null && other.detallePrefacturaPK != null) || (this.detallePrefacturaPK != null && !this.detallePrefacturaPK.equals(other.detallePrefacturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gscars.backend.entidades.DetallePrefactura[ detallePrefacturaPK=" + detallePrefacturaPK + " ]";
    }
    
}
