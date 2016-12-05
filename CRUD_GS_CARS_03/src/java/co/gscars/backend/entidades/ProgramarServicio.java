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
@Table(name = "programarservicios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramarServicio.findAll", query = "SELECT p FROM ProgramarServicio p"),
    @NamedQuery(name = "ProgramarServicio.findByIdProgramarServicio", query = "SELECT p FROM ProgramarServicio p WHERE p.idProgramarServicio = :idProgramarServicio"),
    @NamedQuery(name = "ProgramarServicio.findByFecha", query = "SELECT p FROM ProgramarServicio p WHERE p.fecha = :fecha")})
public class ProgramarServicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProgramarServicio")
    private Integer idProgramarServicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idEmpleado", referencedColumnName = "idEmpleado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado idEmpleado;
    @JoinColumn(name = "idInspeccion", referencedColumnName = "idInspeccion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Inspeccion idInspeccion;
    @JoinColumn(name = "idEstadoServicio", referencedColumnName = "idEstadosServicio")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoServicio idEstadoServicio;
    @JoinColumn(name = "idCliente", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idCliente;
    @JoinColumn(name = "idServicio", referencedColumnName = "idServicio")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Servicio idServicio;

    public ProgramarServicio() {
    }

    public ProgramarServicio(Integer idProgramarServicio) {
        this.idProgramarServicio = idProgramarServicio;
    }

    public ProgramarServicio(Integer idProgramarServicio, Date fecha) {
        this.idProgramarServicio = idProgramarServicio;
        this.fecha = fecha;
    }

    public Integer getIdProgramarServicio() {
        return idProgramarServicio;
    }

    public void setIdProgramarServicio(Integer idProgramarServicio) {
        this.idProgramarServicio = idProgramarServicio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Inspeccion getIdInspeccion() {
        return idInspeccion;
    }

    public void setIdInspeccion(Inspeccion idInspeccion) {
        this.idInspeccion = idInspeccion;
    }

    public EstadoServicio getIdEstadoServicio() {
        return idEstadoServicio;
    }

    public void setIdEstadoServicio(EstadoServicio idEstadoServicio) {
        this.idEstadoServicio = idEstadoServicio;
    }

    public Usuario getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Usuario idCliente) {
        this.idCliente = idCliente;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProgramarServicio != null ? idProgramarServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramarServicio)) {
            return false;
        }
        ProgramarServicio other = (ProgramarServicio) object;
        if ((this.idProgramarServicio == null && other.idProgramarServicio != null) || (this.idProgramarServicio != null && !this.idProgramarServicio.equals(other.idProgramarServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gscars.backend.entidades.ProgramarServicio[ idProgramarServicio=" + idProgramarServicio + " ]";
    }
    
}
