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
@Table(name = "estadosservicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoServicio.findAll", query = "SELECT e FROM EstadoServicio e"),
    @NamedQuery(name = "EstadoServicio.findByIdEstadosServicio", query = "SELECT e FROM EstadoServicio e WHERE e.idEstadosServicio = :idEstadosServicio"),
    @NamedQuery(name = "EstadoServicio.findByNombre", query = "SELECT e FROM EstadoServicio e WHERE e.nombre = :nombre")})
public class EstadoServicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstadosServicio")
    private Integer idEstadosServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoServicio", fetch = FetchType.LAZY)
    private List<ProgramarServicio> programarServicioList;

    public EstadoServicio() {
    }

    public EstadoServicio(Integer idEstadosServicio) {
        this.idEstadosServicio = idEstadosServicio;
    }

    public EstadoServicio(Integer idEstadosServicio, String nombre) {
        this.idEstadosServicio = idEstadosServicio;
        this.nombre = nombre;
    }

    public Integer getIdEstadosServicio() {
        return idEstadosServicio;
    }

    public void setIdEstadosServicio(Integer idEstadosServicio) {
        this.idEstadosServicio = idEstadosServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<ProgramarServicio> getProgramarServicioList() {
        return programarServicioList;
    }

    public void setProgramarServicioList(List<ProgramarServicio> programarServicioList) {
        this.programarServicioList = programarServicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadosServicio != null ? idEstadosServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoServicio)) {
            return false;
        }
        EstadoServicio other = (EstadoServicio) object;
        if ((this.idEstadosServicio == null && other.idEstadosServicio != null) || (this.idEstadosServicio != null && !this.idEstadosServicio.equals(other.idEstadosServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gscars.backend.entidades.EstadoServicio[ idEstadosServicio=" + idEstadosServicio + " ]";
    }
    
}
