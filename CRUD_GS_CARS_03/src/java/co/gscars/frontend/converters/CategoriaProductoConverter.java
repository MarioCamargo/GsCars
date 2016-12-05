package co.gscars.frontend.converters;

import co.gscars.backend.entidades.CategoriaProducto;
import co.gscars.backend.facades.CategoriaProductoFacadeLocal;
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
@FacesConverter(value = "categoriaProductoConverter")
@SessionScoped
public class CategoriaProductoConverter implements Converter{
    
    @EJB
    private CategoriaProductoFacadeLocal categoriaProductoFacade;

    public CategoriaProductoConverter() {
    }

    @Override
    public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
        List<CategoriaProducto> categoriaProductos = this.categoriaProductoFacade.findAll();
        for (CategoriaProducto objeto : categoriaProductos) {
            if (objeto.getIdCategoriaProducto()== Integer.parseInt(valor)) {
                return objeto;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
        if (objeto != null) {
            return ((CategoriaProducto) objeto).getIdCategoriaProducto().toString();
        } else {
            return "";
        }
    }
}
