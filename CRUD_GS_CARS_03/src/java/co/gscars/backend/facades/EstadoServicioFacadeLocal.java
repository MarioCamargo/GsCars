/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.backend.facades;

import co.gscars.backend.entidades.EstadoServicio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bryan
 */
@Local
public interface EstadoServicioFacadeLocal {

    void create(EstadoServicio estadoServicio);

    void edit(EstadoServicio estadoServicio);

    void remove(EstadoServicio estadoServicio);

    EstadoServicio find(Object id);

    List<EstadoServicio> findAll();

    List<EstadoServicio> findRange(int[] range);

    int count();
    
}
