/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.backend.facades;

import co.gscars.backend.entidades.DetallePrefactura;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bryan
 */
@Local
public interface DetallePrefacturaFacadeLocal {

    void create(DetallePrefactura detallePrefactura);

    void edit(DetallePrefactura detallePrefactura);

    void remove(DetallePrefactura detallePrefactura);

    DetallePrefactura find(Object id);

    List<DetallePrefactura> findAll();

    List<DetallePrefactura> findRange(int[] range);

    int count();
    
}
