/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.backend.facades;

import co.gscars.backend.entidades.ProductoInspecion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bryan
 */
@Local
public interface ProductoInspecionFacadeLocal {

    void create(ProductoInspecion productoInspecion);

    void edit(ProductoInspecion productoInspecion);

    void remove(ProductoInspecion productoInspecion);

    ProductoInspecion find(Object id);

    List<ProductoInspecion> findAll();

    List<ProductoInspecion> findRange(int[] range);

    int count();
    
}
