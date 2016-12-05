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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bryan
 */
@Entity
@Table(name = "postuladosofertas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PostuladoOferta.findAll", query = "SELECT p FROM PostuladoOferta p"),
    @NamedQuery(name = "PostuladoOferta.findByIdPostuladoOferta", query = "SELECT p FROM PostuladoOferta p WHERE p.idPostuladoOferta = :idPostuladoOferta")})
public class PostuladoOferta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPostuladoOferta")
    private Integer idPostuladoOferta;
    @JoinColumn(name = "idCliente", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idCliente;
    @JoinColumn(name = "idOferta", referencedColumnName = "idOferta")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Oferta idOferta;

    public PostuladoOferta() {
    }

    public PostuladoOferta(Integer idPostuladoOferta) {
        this.idPostuladoOferta = idPostuladoOferta;
    }

    public Integer getIdPostuladoOferta() {
        return idPostuladoOferta;
    }

    public void setIdPostuladoOferta(Integer idPostuladoOferta) {
        this.idPostuladoOferta = idPostuladoOferta;
    }

    public Usuario getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Usuario idCliente) {
        this.idCliente = idCliente;
    }

    public Oferta getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Oferta idOferta) {
        this.idOferta = idOferta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPostuladoOferta != null ? idPostuladoOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PostuladoOferta)) {
            return false;
        }
        PostuladoOferta other = (PostuladoOferta) object;
        if ((this.idPostuladoOferta == null && other.idPostuladoOferta != null) || (this.idPostuladoOferta != null && !this.idPostuladoOferta.equals(other.idPostuladoOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gscars.backend.entidades.PostuladoOferta[ idPostuladoOferta=" + idPostuladoOferta + " ]";
    }
    
}
