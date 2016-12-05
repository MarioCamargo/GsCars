/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.backend.facades;

import co.gscars.backend.entidades.OfertaLaboral;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bryan
 */
@Local
public interface OfertaLaboralFacadeLocal {

    void create(OfertaLaboral ofertaLaboral);

    void edit(OfertaLaboral ofertaLaboral);

    void remove(OfertaLaboral ofertaLaboral);

    OfertaLaboral find(Object id);

    List<OfertaLaboral> findAll();

    List<OfertaLaboral> findRange(int[] range);

    int count();
    
}
