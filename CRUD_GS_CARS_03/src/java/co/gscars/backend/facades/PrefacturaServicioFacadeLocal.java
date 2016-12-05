/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.backend.facades;

import co.gscars.backend.entidades.PrefacturaServicio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bryan
 */
@Local
public interface PrefacturaServicioFacadeLocal {

    void create(PrefacturaServicio prefacturaServicio);

    void edit(PrefacturaServicio prefacturaServicio);

    void remove(PrefacturaServicio prefacturaServicio);

    PrefacturaServicio find(Object id);

    List<PrefacturaServicio> findAll();

    List<PrefacturaServicio> findRange(int[] range);

    int count();
    
}
