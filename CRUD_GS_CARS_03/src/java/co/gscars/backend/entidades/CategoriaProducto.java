/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gscars.backend.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "categoriasproducto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaProducto.findAll", query = "SELECT c FROM CategoriaProducto c"),
    @NamedQuery(name = "CategoriaProducto.findByIdCategoriaProducto", query = "SELECT c FROM CategoriaProducto c WHERE c.idCategoriaProducto = :idCategoriaProducto"),
    @NamedQuery(name = "CategoriaProducto.findByNombre", query = "SELECT c FROM CategoriaProducto c WHERE c.nombre = :nombre")})
public class CategoriaProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCategoriaProducto")
    private Integer idCategoriaProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre")
    private String nombre;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoriaProducto", fetch = FetchType.LAZY)
//    private List<Producto> productoList;

    public CategoriaProducto() {
    }

    public CategoriaProducto(Integer idCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
    }

    public CategoriaProducto(Integer idCategoriaProducto, String nombre) {
        this.idCategoriaProducto = idCategoriaProducto;
        this.nombre = nombre;
    }

    public Integer getIdCategoriaProducto() {
        return idCategoriaProducto;
    }

    public void setIdCategoriaProducto(Integer idCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

//    @XmlTransient
//    public List<Producto> getProductoList() {
//        return productoList;
//    }
//
//    public void setProductoList(List<Producto> productoList) {
//        this.productoList = productoList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoriaProducto != null ? idCategoriaProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaProducto)) {
            return false;
        }
        CategoriaProducto other = (CategoriaProducto) object;
        if ((this.idCategoriaProducto == null && other.idCategoriaProducto != null) || (this.idCategoriaProducto != null && !this.idCategoriaProducto.equals(other.idCategoriaProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gscars.backend.entidades.CategoriaProducto[ idCategoriaProducto=" + idCategoriaProducto + " ]";
    }

}
