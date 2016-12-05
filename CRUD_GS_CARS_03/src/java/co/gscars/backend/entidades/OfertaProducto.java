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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bryan
 */
@Entity
@Table(name = "ofertasproductos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OfertaProducto.findAll", query = "SELECT o FROM OfertaProducto o"),
    @NamedQuery(name = "OfertaProducto.findByIdOfertaProducto", query = "SELECT o FROM OfertaProducto o WHERE o.idOfertaProducto = :idOfertaProducto"),
    @NamedQuery(name = "OfertaProducto.findByNombre", query = "SELECT o FROM OfertaProducto o WHERE o.nombre = :nombre"),
    @NamedQuery(name = "OfertaProducto.findByDescuento", query = "SELECT o FROM OfertaProducto o WHERE o.descuento = :descuento")})
public class OfertaProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOfertaProducto")
    private Integer idOfertaProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento")
    private int descuento;
    @JoinColumn(name = "idOferta", referencedColumnName = "idOferta")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Oferta idOferta;
    @JoinColumn(name = "producto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto producto;

    public OfertaProducto() {
    }

    public OfertaProducto(Integer idOfertaProducto) {
        this.idOfertaProducto = idOfertaProducto;
    }

    public OfertaProducto(Integer idOfertaProducto, String nombre, int descuento) {
        this.idOfertaProducto = idOfertaProducto;
        this.nombre = nombre;
        this.descuento = descuento;
    }

    public Integer getIdOfertaProducto() {
        return idOfertaProducto;
    }

    public void setIdOfertaProducto(Integer idOfertaProducto) {
        this.idOfertaProducto = idOfertaProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public Oferta getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Oferta idOferta) {
        this.idOferta = idOferta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOfertaProducto != null ? idOfertaProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfertaProducto)) {
            return false;
        }
        OfertaProducto other = (OfertaProducto) object;
        if ((this.idOfertaProducto == null && other.idOfertaProducto != null) || (this.idOfertaProducto != null && !this.idOfertaProducto.equals(other.idOfertaProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gscars.backend.entidades.OfertaProducto[ idOfertaProducto=" + idOfertaProducto + " ]";
    }
    
}
