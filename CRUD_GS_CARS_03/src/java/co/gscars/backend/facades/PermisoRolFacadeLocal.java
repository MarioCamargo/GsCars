/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.backend.facades;

import co.gscars.backend.entidades.PermisoRol;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bryan
 */
@Local
public interface PermisoRolFacadeLocal {

    void create(PermisoRol permisoRol);

    void edit(PermisoRol permisoRol);

    void remove(PermisoRol permisoRol);

    PermisoRol find(Object id);

    List<PermisoRol> findAll();

    List<PermisoRol> findRange(int[] range);

    int count();
    
}
