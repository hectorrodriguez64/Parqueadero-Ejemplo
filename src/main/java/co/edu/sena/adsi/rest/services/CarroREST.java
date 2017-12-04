/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Carro;
import co.edu.sena.adsi.jpa.entities.Parqueadero;
import co.edu.sena.adsi.jpa.entities.Puesto;
import co.edu.sena.adsi.jpa.sessions.CarroFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
@Path("carros")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarroREST {

    @EJB
    private CarroFacade carroEJB;

    @GET
    public List<Carro> findAll() {
        return carroEJB.findAll();
    }

    @GET
    @Path("{id}")
    public Carro findBye(
            @PathParam("nombre") String nombre) {
        return carroEJB.find(nombre);
    }

    @POST
    public void create(Carro carro)
      {
        carroEJB.create(carro);
        
               
    }
    
     

  
}
