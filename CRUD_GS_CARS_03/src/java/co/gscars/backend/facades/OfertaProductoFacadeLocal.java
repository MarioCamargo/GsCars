/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.backend.facades;

import co.gscars.backend.entidades.OfertaProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bryan
 */
@Local
public interface OfertaProductoFacadeLocal {

    void create(OfertaProducto ofertaProducto);

    void edit(OfertaProducto ofertaProducto);

    void remove(OfertaProducto ofertaProducto);

    OfertaProducto find(Object id);

    List<OfertaProducto> findAll();

    List<OfertaProducto> findRange(int[] range);

    int count();
    
}
