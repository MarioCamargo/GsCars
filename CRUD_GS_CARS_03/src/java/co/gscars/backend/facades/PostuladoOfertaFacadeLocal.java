/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.backend.facades;

import co.gscars.backend.entidades.PostuladoOferta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Bryan
 */
@Local
public interface PostuladoOfertaFacadeLocal {

    void create(PostuladoOferta postuladoOferta);

    void edit(PostuladoOferta postuladoOferta);

    void remove(PostuladoOferta postuladoOferta);

    PostuladoOferta find(Object id);

    List<PostuladoOferta> findAll();

    List<PostuladoOferta> findRange(int[] range);

    int count();
    
}
