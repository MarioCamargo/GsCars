/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.backend.facades;

import co.gscars.backend.entidades.LineaVehiculo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Bryan
 */
@Stateless
public class LineaVehiculoFacade extends AbstractFacade<LineaVehiculo> implements LineaVehiculoFacadeLocal {
    @PersistenceContext(unitName = "CRUD_GS_CARS_02PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LineaVehiculoFacade() {
        super(LineaVehiculo.class);
    }
    
}
