/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.backend.facades;

import co.gscars.backend.entidades.LineaVehiculo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bryan
 */
@Local
public interface LineaVehiculoFacadeLocal {

    void create(LineaVehiculo lineaVehiculo);

    void edit(LineaVehiculo lineaVehiculo);

    void remove(LineaVehiculo lineaVehiculo);

    LineaVehiculo find(Object id);

    List<LineaVehiculo> findAll();

    List<LineaVehiculo> findRange(int[] range);

    int count();
    
}
