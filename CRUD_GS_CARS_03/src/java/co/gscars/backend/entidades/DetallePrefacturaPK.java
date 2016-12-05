/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.backend.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Bryan
 */
@Embeddable
public class DetallePrefacturaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPreFacturaProducto")
    private int idPreFacturaProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProducto")
    private int idProducto;

    public DetallePrefacturaPK() {
    }

    public DetallePrefacturaPK(int idPreFacturaProducto, int idProducto) {
        this.idPreFacturaProducto = idPreFacturaProducto;
        this.idProducto = idProducto;
    }

    public int getIdPreFacturaProducto() {
        return idPreFacturaProducto;
    }

    public void setIdPreFacturaProducto(int idPreFacturaProducto) {
        this.idPreFacturaProducto = idPreFacturaProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPreFacturaProducto;
        hash += (int) idProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePrefacturaPK)) {
            return false;
        }
        DetallePrefacturaPK other = (DetallePrefacturaPK) object;
        if (this.idPreFacturaProducto != other.idPreFacturaProducto) {
            return false;
        }
        if (this.idProducto != other.idProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gscars.backend.entidades.DetallePrefacturaPK[ idPreFacturaProducto=" + idPreFacturaProducto + ", idProducto=" + idProducto + " ]";
    }
    
}
