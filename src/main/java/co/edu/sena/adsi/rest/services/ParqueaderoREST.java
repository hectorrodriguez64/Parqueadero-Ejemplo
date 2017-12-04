/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Carro;
import co.edu.sena.adsi.jpa.entities.Parqueadero;
import co.edu.sena.adsi.jpa.entities.Puesto;

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
    public List<Parqueadero> findAll() {
        return parqueaderoEJB.findAll();
    }

    @GET
    @Path("{id}")
    public Parqueadero findBye(
            @PathParam("nombre") String nombre) {
        return parqueaderoEJB.find(nombre);
    }

    @POST
    public void create(
            @QueryParam("tarifa") double tarifa,
            @QueryParam("horaActual") Date horaActual
            ) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Parqueadero newParqueadero = new Parqueadero();
        Carro newCarro = new Carro();

        try {
            newParqueadero.setValorPagar(pagarValor(tarifa));
            newParqueadero.setCaja(newParqueadero.getCaja() + tarifa);
            newParqueadero.setPuestos(newParqueadero.getPuestos() - 1);
            newParqueadero.setAbierto(true);
            newParqueadero.setTarifa(tarifaParcial());
        } catch (Exception e) {

        }
    }
    private int resta = 1;
    private int horaActual;
    private int horaLlegada;

    private double pagarValor(double tarifa) {
        tarifa = tarifaParcial() * restaHora();
        return tarifa;
    }
    //Cambiar tarifa
    private double tarifaParcial() {
        return 1200;
    }

    public int restaHora() {
        resta = horaActual - horaLlegada;
        return resta;

    }
    public static final int PARQUEADERO_CERRADO = -2;
    public static final int CARRO_NO_EXISTE = -3;
    public static final int CARRO_YA_EXISTE = -4;
    public static final int HORA_INICIAL = 6;
    public static final int HORA_CIERRE = 20;
    public static final int NOHAYPUESTO = -1;
    public static final int TAMAÑO = 40;

    private Puesto puestos[];

    public int ingresarCarro(String placa) {
        if(false) {
            return PARQUEADERO_CERRADO;
        }
        // Buscar un puesto libre para el carro y agregarlo
        int numPuesto = 0;
        if (numPuesto != NOHAYPUESTO) {
            Carro carroEntrando = new Carro(placa, horaActual);
            puestos[numPuesto].parquearCarro(carroEntrando);
        }
        return numPuesto;

    }
    
    public int calcularPuestos()
    {
        int puestosLibres = 0;
        for(int i = 0; i < TAMAÑO; i++)
            if( !puestos[i].puestoOcupado())
                puestosLibres = puestosLibres + 1;
        return puestosLibres;
    }
   
    public boolean estaOcupado(int i){
        return puestos[i].puestoOcupado();
    }
   
}
