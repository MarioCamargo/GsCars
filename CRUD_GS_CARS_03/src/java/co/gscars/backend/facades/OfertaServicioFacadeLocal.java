/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.backend.facades;

import co.gscars.backend.entidades.OfertaServicio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bryan
 */
@Local
public interface OfertaServicioFacadeLocal {

    void create(OfertaServicio ofertaServicio);

    void edit(OfertaServicio ofertaServicio);

    void remove(OfertaServicio ofertaServicio);

    OfertaServicio find(Object id);

    List<OfertaServicio> findAll();

    List<OfertaServicio> findRange(int[] range);

    int count();
    
}
