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
@Table(name = "productosinspecion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoInspecion.findAll", query = "SELECT p FROM ProductoInspecion p"),
    @NamedQuery(name = "ProductoInspecion.findByIdproductosInspecion", query = "SELECT p FROM ProductoInspecion p WHERE p.idproductosInspecion = :idproductosInspecion"),
    @NamedQuery(name = "ProductoInspecion.findByCantidad", query = "SELECT p FROM ProductoInspecion p WHERE p.cantidad = :cantidad")})
public class ProductoInspecion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproductosInspecion")
    private Integer idproductosInspecion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto idProducto;
    @JoinColumn(name = "idInspeccion", referencedColumnName = "idInspeccion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Inspeccion idInspeccion;

    public ProductoInspecion() {
    }

    public ProductoInspecion(Integer idproductosInspecion) {
        this.idproductosInspecion = idproductosInspecion;
    }

    public ProductoInspecion(Integer idproductosInspecion, int cantidad) {
        this.idproductosInspecion = idproductosInspecion;
        this.cantidad = cantidad;
    }

    public Integer getIdproductosInspecion() {
        return idproductosInspecion;
    }

    public void setIdproductosInspecion(Integer idproductosInspecion) {
        this.idproductosInspecion = idproductosInspecion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
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
        hash += (idproductosInspecion != null ? idproductosInspecion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoInspecion)) {
            return false;
        }
        ProductoInspecion other = (ProductoInspecion) object;
        if ((this.idproductosInspecion == null && other.idproductosInspecion != null) || (this.idproductosInspecion != null && !this.idproductosInspecion.equals(other.idproductosInspecion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gscars.backend.entidades.ProductoInspecion[ idproductosInspecion=" + idproductosInspecion + " ]";
    }
    
}
