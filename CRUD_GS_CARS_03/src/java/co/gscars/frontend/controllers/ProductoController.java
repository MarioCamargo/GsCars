/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.frontend.controllers;

import co.gscars.backend.entidades.CategoriaProducto;
import co.gscars.backend.entidades.EstadoProducto;
import co.gscars.backend.entidades.Producto;
import co.gscars.backend.facades.CategoriaProductoFacadeLocal;
import co.gscars.backend.facades.EstadoProductoFacadeLocal;
import co.gscars.backend.facades.ProductoFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Mario Camargo
 */
@ManagedBean
@SessionScoped
public class ProductoController {

    @EJB
    ProductoFacadeLocal productoFacade;
    Producto producto;
    List<Producto> productoLista;
    
    @EJB
    EstadoProductoFacadeLocal estadoProductoFacade;
    EstadoProducto estadoProducto;
    List<EstadoProducto> estadoProductoLista;
    
    @EJB
    CategoriaProductoFacadeLocal categoriaProductoFacade;
    CategoriaProducto categoriaProducto;
    List<CategoriaProducto> categoriaProductoLista;
    
    public ProductoController() {
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public List<Producto> getProductos(){
        return productoFacade.findAll();
    }
    
    public List<Producto> getProductoLista() {
        try{
            productoLista=productoFacade.findAll();
        } catch(Exception e){
            Error(e);
        }
        return productoLista;
    }

    public EstadoProducto getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(EstadoProducto estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public CategoriaProducto getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public void setProductoLista(List<Producto> productoLista) {
        this.productoLista = productoLista;
    }
    
    public List<EstadoProducto> getEstadoProductoLista() {
        estadoProductoLista=estadoProductoFacade.findAll();
        return estadoProductoLista;
    }

    public void setEstadoProductoLista(List<EstadoProducto> estadoProductoLista) {
        this.estadoProductoLista = estadoProductoLista;
    }
    
    public List<CategoriaProducto> getCategoriaProductoLista() {
        categoriaProductoLista=categoriaProductoFacade.findAll();
        return categoriaProductoLista;
    }

    public void setCategoriaProductoLista(List<CategoriaProducto> categoriaProductoLista) {
        this.categoriaProductoLista = categoriaProductoLista;
    }
    
    @PostConstruct
    public void init(){
        producto = new Producto();
    }
    
    public void crearProducto(){
        try{
            productoFacade.create(producto);
            Exito("registrar el producto");
        } catch(Exception e){
            Error(e);
        }  
    }
    
    public  String registrar(){
        return "listarProductos";
    }
    
    public String modificar(Producto pro)
    {
        this.producto = pro;
        return "modificarProducto";
    }
    
    public void modificarProducto(){
        try{
            productoFacade.edit(producto);
            Exito("modificar el producto");
        } catch(Exception e){
            Error(e);
        }
    }
    
    public void eliminarProducto(Producto p){
        try{
            productoFacade.remove(producto);
            Exito("eliminar el producto");
        } catch(Exception e){
            Error(e);
        }
    }
    
    private void Error(Exception e){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"se produjo el siguiente error: ",e.getMessage()));
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al insertar: ",e.getMessage());
        RequestContext.getCurrentInstance().showMessageInDialog(msg);
    }
    
    private void Exito(String operacion){
        String msg = "Se ha realizado exitosamente la operacion de "+operacion;
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null,new FacesMessage(msg));
        FacesMessage sal = new FacesMessage(FacesMessage.SEVERITY_INFO,"Opereción exitosa: ",msg);
        RequestContext.getCurrentInstance().showMessageInDialog(sal);
    }
}