/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.backend.facades;

import co.gscars.backend.entidades.ProgramarServicio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bryan
 */
@Local
public interface ProgramarServicioFacadeLocal {

    void create(ProgramarServicio programarServicio);

    void edit(ProgramarServicio programarServicio);

    void remove(ProgramarServicio programarServicio);

    ProgramarServicio find(Object id);

    List<ProgramarServicio> findAll();

    List<ProgramarServicio> findRange(int[] range);

    int count();
    
}
