/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.backend.facades;

import co.gscars.backend.entidades.PrefacturaProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bryan
 */
@Local
public interface PrefacturaProductoFacadeLocal {

    void create(PrefacturaProducto prefacturaProducto);

    void edit(PrefacturaProducto prefacturaProducto);

    void remove(PrefacturaProducto prefacturaProducto);

    PrefacturaProducto find(Object id);

    List<PrefacturaProducto> findAll();

    List<PrefacturaProducto> findRange(int[] range);

    int count();
    
}
