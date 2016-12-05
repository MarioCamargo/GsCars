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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "lineasvehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LineaVehiculo.findAll", query = "SELECT l FROM LineaVehiculo l"),
    @NamedQuery(name = "LineaVehiculo.findByIdLineasVehiculo", query = "SELECT l FROM LineaVehiculo l WHERE l.idLineasVehiculo = :idLineasVehiculo"),
    @NamedQuery(name = "LineaVehiculo.findByNombre", query = "SELECT l FROM LineaVehiculo l WHERE l.nombre = :nombre")})
public class LineaVehiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLineasVehiculo")
    private Integer idLineasVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLineaVehiculo", fetch = FetchType.LAZY)
    private List<Vehiculo> vehiculoList;
    @JoinColumn(name = "idMarcaVehiculo", referencedColumnName = "idMarcaVehiculo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MarcaVehiculo idMarcaVehiculo;

    public LineaVehiculo() {
    }

    public LineaVehiculo(Integer idLineasVehiculo) {
        this.idLineasVehiculo = idLineasVehiculo;
    }

    public LineaVehiculo(Integer idLineasVehiculo, String nombre) {
        this.idLineasVehiculo = idLineasVehiculo;
        this.nombre = nombre;
    }

    public Integer getIdLineasVehiculo() {
        return idLineasVehiculo;
    }

    public void setIdLineasVehiculo(Integer idLineasVehiculo) {
        this.idLineasVehiculo = idLineasVehiculo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    public MarcaVehiculo getIdMarcaVehiculo() {
        return idMarcaVehiculo;
    }

    public void setIdMarcaVehiculo(MarcaVehiculo idMarcaVehiculo) {
        this.idMarcaVehiculo = idMarcaVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLineasVehiculo != null ? idLineasVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LineaVehiculo)) {
            return false;
        }
        LineaVehiculo other = (LineaVehiculo) object;
        if ((this.idLineasVehiculo == null && other.idLineasVehiculo != null) || (this.idLineasVehiculo != null && !this.idLineasVehiculo.equals(other.idLineasVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gscars.backend.entidades.LineaVehiculo[ idLineasVehiculo=" + idLineasVehiculo + " ]";
    }
    
}
