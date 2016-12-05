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
@Table(name = "marcavehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MarcaVehiculo.findAll", query = "SELECT m FROM MarcaVehiculo m"),
    @NamedQuery(name = "MarcaVehiculo.findByIdMarcaVehiculo", query = "SELECT m FROM MarcaVehiculo m WHERE m.idMarcaVehiculo = :idMarcaVehiculo"),
    @NamedQuery(name = "MarcaVehiculo.findByNombre", query = "SELECT m FROM MarcaVehiculo m WHERE m.nombre = :nombre")})
public class MarcaVehiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMarcaVehiculo")
    private Integer idMarcaVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMarcaVehiculo", fetch = FetchType.LAZY)
    private List<LineaVehiculo> lineaVehiculoList;

    public MarcaVehiculo() {
    }

    public MarcaVehiculo(Integer idMarcaVehiculo) {
        this.idMarcaVehiculo = idMarcaVehiculo;
    }

    public MarcaVehiculo(Integer idMarcaVehiculo, String nombre) {
        this.idMarcaVehiculo = idMarcaVehiculo;
        this.nombre = nombre;
    }

    public Integer getIdMarcaVehiculo() {
        return idMarcaVehiculo;
    }

    public void setIdMarcaVehiculo(Integer idMarcaVehiculo) {
        this.idMarcaVehiculo = idMarcaVehiculo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<LineaVehiculo> getLineaVehiculoList() {
        return lineaVehiculoList;
    }

    public void setLineaVehiculoList(List<LineaVehiculo> lineaVehiculoList) {
        this.lineaVehiculoList = lineaVehiculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMarcaVehiculo != null ? idMarcaVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MarcaVehiculo)) {
            return false;
        }
        MarcaVehiculo other = (MarcaVehiculo) object;
        if ((this.idMarcaVehiculo == null && other.idMarcaVehiculo != null) || (this.idMarcaVehiculo != null && !this.idMarcaVehiculo.equals(other.idMarcaVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gscars.backend.entidades.MarcaVehiculo[ idMarcaVehiculo=" + idMarcaVehiculo + " ]";
    }
    
}
