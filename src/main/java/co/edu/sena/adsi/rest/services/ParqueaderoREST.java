/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Carro;
import co.edu.sena.adsi.jpa.entities.Parqueadero;
import co.edu.sena.adsi.jpa.sessions.ParqueaderoFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adsi1261718
 */
@Path("parqueaderos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ParqueaderoREST {
    @EJB
    private ParqueaderoFacade parqueaderoEJB;
    
    @GET
    public List<Parqueadero> findAll(){
        return parqueaderoEJB.findAll();
    }
    @GET
    @Path("{id}")
    public Parqueadero findBye(
    @PathParam("nombre")String nombre){
        return parqueaderoEJB.find(nombre);
    }
      @POST
    public void create(
        @QueryParam("tarifa") double tarifa,
        @QueryParam("horaActual") Date horaActual){
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Parqueadero newParqueadero = new Parqueadero();
        Carro newCarros = new Carro();
        
        try{
           /** newCahorros.setRetirar(retirarValor(newUsuarios.getSaldoTotal(), saldo));
            newCahorros.setConsignar(consignarValor(newUsuarios.getSaldoTotal(), saldo));
            newCahorros.setSaldo(saldo);
            newCahorros.setInteresMensual(interesMensual);
            newCahorros.setIdUsuarios(newUsuarios);**/
        }catch (Exception e) {
      
        }        
    }
    

        private double pagarValor(double valor, double saldoTotal ){
        saldoTotal = saldoTotal + valor;
        return saldoTotal;
        
        
    }
}
