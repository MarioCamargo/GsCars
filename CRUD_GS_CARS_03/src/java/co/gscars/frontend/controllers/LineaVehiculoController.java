/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gscars.frontend.controllers;

import co.gscars.backend.entidades.LineaVehiculo;
import co.gscars.backend.entidades.MarcaVehiculo;
import co.gscars.backend.facades.LineaVehiculoFacadeLocal;
import co.gscars.backend.facades.MarcaVehiculoFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Bryan
 */
@ManagedBean
@RequestScoped
public class LineaVehiculoController {

    @EJB
    private LineaVehiculoFacadeLocal lineaVehiculoFacadeLocal;
    private LineaVehiculo lineaVehiculo;
    
    @EJB
    private MarcaVehiculoFacadeLocal marcaVehiculoFacadeLocal;
    private List <MarcaVehiculo> marcaVehiculoList;

    public LineaVehiculo getLineaVehiculo() {
        return lineaVehiculo;
    }

    public void setLineaVehiculo(LineaVehiculo lineaVehiculo) {
        this.lineaVehiculo = lineaVehiculo;
    }

    public List<MarcaVehiculo> getMarcaVehiculoList() {
        marcaVehiculoList = marcaVehiculoFacadeLocal.findAll();
        return marcaVehiculoList;
    }

    public void setMarcaVehiculoList(List<MarcaVehiculo> marcaVehiculoList) {
        this.marcaVehiculoList = marcaVehiculoList;
    }
    
    @PostConstruct
    public void init(){
        lineaVehiculo = new LineaVehiculo();
    }
    
    String salida = "";
    
    public String registrarLinea(){
        try{
            lineaVehiculoFacadeLocal.create(lineaVehiculo);
        }catch(Exception e){
            
            salida = e.getMessage();
        }
        return salida;
        
    }
    
}
