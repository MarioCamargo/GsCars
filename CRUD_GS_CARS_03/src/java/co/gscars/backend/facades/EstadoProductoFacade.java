/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.backend.facades;

import co.gscars.backend.entidades.EstadoProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Bryan
 */
@Stateless
public class EstadoProductoFacade extends AbstractFacade<EstadoProducto> implements EstadoProductoFacadeLocal {
    @PersistenceContext(unitName = "CRUD_GS_CARS_02PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoProductoFacade() {
        super(EstadoProducto.class);
    }
    
}
