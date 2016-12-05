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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bryan
 */
@Entity
@Table(name = "inspecciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inspeccion.findAll", query = "SELECT i FROM Inspeccion i"),
    @NamedQuery(name = "Inspeccion.findByIdInspeccion", query = "SELECT i FROM Inspeccion i WHERE i.idInspeccion = :idInspeccion"),
    @NamedQuery(name = "Inspeccion.findByDescripcionDa\u00f1os", query = "SELECT i FROM Inspeccion i WHERE i.descripcionDa\u00f1os = :descripcionDa\u00f1os"),
    @NamedQuery(name = "Inspeccion.findByFechaEntrada", query = "SELECT i FROM Inspeccion i WHERE i.fechaEntrada = :fechaEntrada"),
    @NamedQuery(name = "Inspeccion.findByIdProducto", query = "SELECT i FROM Inspeccion i WHERE i.idProducto = :idProducto")})
public class Inspeccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idInspeccion")
    private Integer idInspeccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcionDa\u00f1os")
    private String descripcionDaños;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaEntrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProducto")
    private int idProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInspeccion", fetch = FetchType.LAZY)
    private List<ProgramarServicio> programarServicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInspeccion", fetch = FetchType.LAZY)
    private List<ProductoInspecion> productoInspecionList;
    @JoinColumn(name = "placa", referencedColumnName = "placa")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vehiculo placa;
    @JoinColumn(name = "idAdministrador", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idAdministrador;
    @JoinColumn(name = "idTaller", referencedColumnName = "idTaller")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Taller idTaller;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInspeccion", fetch = FetchType.LAZY)
    private List<PrefacturaServicio> prefacturaServicioList;

    public Inspeccion() {
    }

    public Inspeccion(Integer idInspeccion) {
        this.idInspeccion = idInspeccion;
    }

    public Inspeccion(Integer idInspeccion, String descripcionDaños, Date fechaEntrada, int idProducto) {
        this.idInspeccion = idInspeccion;
        this.descripcionDaños = descripcionDaños;
        this.fechaEntrada = fechaEntrada;
        this.idProducto = idProducto;
    }

    public Integer getIdInspeccion() {
        return idInspeccion;
    }

    public void setIdInspeccion(Integer idInspeccion) {
        this.idInspeccion = idInspeccion;
    }

    public String getDescripcionDaños() {
        return descripcionDaños;
    }

    public void setDescripcionDaños(String descripcionDaños) {
        this.descripcionDaños = descripcionDaños;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @XmlTransient
    public List<ProgramarServicio> getProgramarServicioList() {
        return programarServicioList;
    }

    public void setProgramarServicioList(List<ProgramarServicio> programarServicioList) {
        this.programarServicioList = programarServicioList;
    }

    @XmlTransient
    public List<ProductoInspecion> getProductoInspecionList() {
        return productoInspecionList;
    }

    public void setProductoInspecionList(List<ProductoInspecion> productoInspecionList) {
        this.productoInspecionList = productoInspecionList;
    }

    public Vehiculo getPlaca() {
        return placa;
    }

    public void setPlaca(Vehiculo placa) {
        this.placa = placa;
    }

    public Usuario getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Usuario idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public Taller getIdTaller() {
        return idTaller;
    }

    public void setIdTaller(Taller idTaller) {
        this.idTaller = idTaller;
    }

    @XmlTransient
    public List<PrefacturaServicio> getPrefacturaServicioList() {
        return prefacturaServicioList;
    }

    public void setPrefacturaServicioList(List<PrefacturaServicio> prefacturaServicioList) {
        this.prefacturaServicioList = prefacturaServicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInspeccion != null ? idInspeccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inspeccion)) {
            return false;
        }
        Inspeccion other = (Inspeccion) object;
        if ((this.idInspeccion == null && other.idInspeccion != null) || (this.idInspeccion != null && !this.idInspeccion.equals(other.idInspeccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gscars.backend.entidades.Inspeccion[ idInspeccion=" + idInspeccion + " ]";
    }
    
}
