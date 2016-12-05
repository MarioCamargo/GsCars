/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.backend.facades;

import co.gscars.backend.entidades.MarcaVehiculo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bryan
 */
@Local
public interface MarcaVehiculoFacadeLocal {

    void create(MarcaVehiculo marcaVehiculo);

    void edit(MarcaVehiculo marcaVehiculo);

    void remove(MarcaVehiculo marcaVehiculo);

    MarcaVehiculo find(Object id);

    List<MarcaVehiculo> findAll();

    List<MarcaVehiculo> findRange(int[] range);

    int count();
    
}
