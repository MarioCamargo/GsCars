/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.backend.facades;

import co.gscars.backend.entidades.EstadoOferta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bryan
 */
@Local
public interface EstadoOfertaFacadeLocal {

    void create(EstadoOferta estadoOferta);

    void edit(EstadoOferta estadoOferta);

    void remove(EstadoOferta estadoOferta);

    EstadoOferta find(Object id);

    List<EstadoOferta> findAll();

    List<EstadoOferta> findRange(int[] range);

    int count();
    
}
