/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.backend.facades;

import co.gscars.backend.entidades.Taller;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bryan
 */
@Local
public interface TallerFacadeLocal {

    void create(Taller taller);

    void edit(Taller taller);

    void remove(Taller taller);

    Taller find(Object id);

    List<Taller> findAll();

    List<Taller> findRange(int[] range);

    int count();
    
}
