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
@Table(name = "ofertas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oferta.findAll", query = "SELECT o FROM Oferta o"),
    @NamedQuery(name = "Oferta.findByIdOferta", query = "SELECT o FROM Oferta o WHERE o.idOferta = :idOferta"),
    @NamedQuery(name = "Oferta.findByUrlImagen", query = "SELECT o FROM Oferta o WHERE o.urlImagen = :urlImagen"),
    @NamedQuery(name = "Oferta.findByFecha", query = "SELECT o FROM Oferta o WHERE o.fecha = :fecha")})
public class Oferta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOferta")
    private Integer idOferta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "urlImagen")
    private String urlImagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOferta", fetch = FetchType.LAZY)
    private List<OfertaLaboral> ofertaLaboralList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOferta", fetch = FetchType.LAZY)
    private List<OfertaProducto> ofertaProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOferta", fetch = FetchType.LAZY)
    private List<OfertaServicio> ofertaServicioList;
    @JoinColumn(name = "idAdministrador", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idAdministrador;
    @JoinColumn(name = "idEstadoOferta", referencedColumnName = "idEstadoOferta")
    @ManyToOne(fetch = FetchType.LAZY)
    private EstadoOferta idEstadoOferta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOferta", fetch = FetchType.LAZY)
    private List<PostuladoOferta> postuladoOfertaList;

    public Oferta() {
    }

    public Oferta(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public Oferta(Integer idOferta, String urlImagen, Date fecha) {
        this.idOferta = idOferta;
        this.urlImagen = urlImagen;
        this.fecha = fecha;
    }

    public Integer getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<OfertaLaboral> getOfertaLaboralList() {
        return ofertaLaboralList;
    }

    public void setOfertaLaboralList(List<OfertaLaboral> ofertaLaboralList) {
        this.ofertaLaboralList = ofertaLaboralList;
    }

    @XmlTransient
    public List<OfertaProducto> getOfertaProductoList() {
        return ofertaProductoList;
    }

    public void setOfertaProductoList(List<OfertaProducto> ofertaProductoList) {
        this.ofertaProductoList = ofertaProductoList;
    }

    @XmlTransient
    public List<OfertaServicio> getOfertaServicioList() {
        return ofertaServicioList;
    }

    public void setOfertaServicioList(List<OfertaServicio> ofertaServicioList) {
        this.ofertaServicioList = ofertaServicioList;
    }

    public Usuario getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Usuario idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public EstadoOferta getIdEstadoOferta() {
        return idEstadoOferta;
    }

    public void setIdEstadoOferta(EstadoOferta idEstadoOferta) {
        this.idEstadoOferta = idEstadoOferta;
    }

    @XmlTransient
    public List<PostuladoOferta> getPostuladoOfertaList() {
        return postuladoOfertaList;
    }

    public void setPostuladoOfertaList(List<PostuladoOferta> postuladoOfertaList) {
        this.postuladoOfertaList = postuladoOfertaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOferta != null ? idOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oferta)) {
            return false;
        }
        Oferta other = (Oferta) object;
        if ((this.idOferta == null && other.idOferta != null) || (this.idOferta != null && !this.idOferta.equals(other.idOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gscars.backend.entidades.Oferta[ idOferta=" + idOferta + " ]";
    }
    
}
