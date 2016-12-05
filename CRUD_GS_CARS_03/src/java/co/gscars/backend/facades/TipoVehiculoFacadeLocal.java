/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.backend.facades;

import co.gscars.backend.entidades.TipoVehiculo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bryan
 */
@Local
public interface TipoVehiculoFacadeLocal {

    void create(TipoVehiculo tipoVehiculo);

    void edit(TipoVehiculo tipoVehiculo);

    void remove(TipoVehiculo tipoVehiculo);

    TipoVehiculo find(Object id);

    List<TipoVehiculo> findAll();

    List<TipoVehiculo> findRange(int[] range);

    int count();
    
}
