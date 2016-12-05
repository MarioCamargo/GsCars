/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.frontend.controllers;

import co.gscars.backend.entidades.Oferta;
import co.gscars.backend.entidades.OfertaLaboral;
import co.gscars.backend.entidades.OfertaProducto;
import co.gscars.backend.entidades.OfertaServicio;
import co.gscars.backend.facades.OfertaFacadeLocal;
import co.gscars.backend.facades.OfertaLaboralFacadeLocal;
import co.gscars.backend.facades.OfertaProductoFacadeLocal;
import co.gscars.backend.facades.OfertaServicioFacadeLocal;
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
public class OfertaController{

    @EJB
    private OfertaFacadeLocal ofertaFacade;
    private Oferta oferta;
    
    @EJB
    private OfertaProductoFacadeLocal ofertaProductoFacade;
    private OfertaProducto ofertaProducto;
    
    @EJB
    private OfertaServicioFacadeLocal ofertaServicioFacade;
    private OfertaServicio ofertaServicio;
    
    @EJB
    private OfertaLaboralFacadeLocal ofertaLaboralFacade;
    private OfertaLaboral ofertaLaboral;
    
    public OfertaController() {
    }

    public OfertaProducto getOfertaProducto() {
        return ofertaProducto;
    }

    public void setOfertaProducto(OfertaProducto ofertaProducto) {
        this.ofertaProducto = ofertaProducto;
    }

    public OfertaServicio getOfertaServicio() {
        return ofertaServicio;
    }

    public void setOfertaServicio(OfertaServicio ofertaServicio) {
        this.ofertaServicio = ofertaServicio;
    }

    public OfertaLaboral getOfertaLaboral() {
        return ofertaLaboral;
    }

    public void setOfertaLaboral(OfertaLaboral ofertaLaboral) {
        this.ofertaLaboral = ofertaLaboral;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }
    
    @PostConstruct
    public void init(){
        oferta = new Oferta();
    }
    
    public String validarOpcion(String opcion){
        String resultado = opcion;
        switch (opcion) {
            case "Producto":
                ofertaProductoFacade.create(ofertaProducto);
                break;
            case "Servicio":
                ofertaServicioFacade.create(ofertaServicio);
                break;
            case "Laboral":
                ofertaLaboralFacade.create(ofertaLaboral);
                break;
        }
        return resultado;
    }
    
    public void crearOferta(){
        
        try{
        ofertaFacade.create(oferta);
        Exito("registrar la oferta");
        } catch(Exception e){
            Error(e);
        }  
    }
    
    public  String registrar(){
        return "listarOfertas";
    }
    
    public String modificar(Oferta ofer)
    {
        this.oferta = ofer;
        return "modificarOferta";
    }
    
    public void modificarProducto(){
        try{
            ofertaFacade.edit(oferta);
            Exito("modificar la oferta");
        } catch(Exception e){
            Error(e);
        }
    }
    
    public void eliminarProducto(Oferta o){
        try{
            ofertaFacade.remove(oferta);
            Exito("eliminar la oferta");
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
