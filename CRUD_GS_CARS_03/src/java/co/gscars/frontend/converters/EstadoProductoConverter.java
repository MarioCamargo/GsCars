/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.frontend.converters;

import co.gscars.backend.entidades.EstadoProducto;
import co.gscars.backend.facades.EstadoProductoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Mario Camargo
 */

@FacesConverter(value = "estadoProductoConverter")
@SessionScoped
public class EstadoProductoConverter implements Converter{
    
    @EJB
    private EstadoProductoFacadeLocal estadoProductoFacade;

    public EstadoProductoConverter() {
    }

    @Override
    public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
        List<EstadoProducto> estadoProductos = this.estadoProductoFacade.findAll();
        for (EstadoProducto objeto : estadoProductos) {
            if (objeto.getIdEstadoProducto()== Integer.parseInt(valor)) {
                return objeto;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
        if (objeto != null) {
            return ((EstadoProducto) objeto).getIdEstadoProducto().toString();
        } else {
            return "";
        }
    }
}
