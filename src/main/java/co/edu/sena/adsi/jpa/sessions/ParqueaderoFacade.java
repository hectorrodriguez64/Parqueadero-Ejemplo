/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.jpa.sessions;

import co.edu.sena.adsi.jpa.entities.Parqueadero;
import co.edu.sena.adsi.jpa.sessions.AbstractFacade;
import co.edu.sena.adsi.rest.services.ParqueaderoREST;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.JOptionPane;

/**
 *
 * @author adsi1261718
 */
@Stateless
public class ParqueaderoFacade extends AbstractFacade<Parqueadero> {

    @PersistenceContext(unitName = "co.edu.sena_Parqueadero_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParqueaderoFacade() {
        super(Parqueadero.class);
    }
    
    
    
    private Parqueadero parqueadero;
    private ParqueaderoREST parqueaderos;

    
    public void ingresar(){
        String placa = JOptionPane.showInputDialog(this, "Por favor digite la placa del carro que está ingresando" );
        if(placa != null){
            int puesto = parqueaderos.ingresarCarro(placa);
            switch(puesto){
                case ParqueaderoREST.NOHAYPUESTO:
                  //JOptionPane.showMessageDialog(this, "Lo sentimos: el parqueadero está lleno..." );
                    break;
                case ParqueaderoREST.CARRO_YA_EXISTE:
              //      JOptionPane.showMessageDialog(this, "Lo sentimos: ya hay un carro parqueado con la misma placa..." );
                    break;                    
                case ParqueaderoREST.PARQUEADERO_CERRADO:
               //     JOptionPane.showMessageDialog(this, "Lo sentimos: el parqueadero está cerrado..." );
                    break;
                default:
               //     JOptionPane.showMessageDialog(this, "Bienvenido:\n Su carro quedó parqueado en el puesto: " + ( puesto + 1 ) + "..." );
                    break;
            }
            //refrescarInformacion();
        }
        //else
           // JOptionPane.showMessageDialog(this, "Placa inválida: intente de nuevo..." );
            
    }
    
    
     /* public void refrescarInformacion(){
        panelParqueadero.refrescarParqueadero();

        panelOperaciones.cambiarHora( parqueadero.darHoraActual());

        panelInformacion.actualizarDatos( parqueadero.calcularPuestosLibres(), parqueadero.darMontoCaja());
    }
*/
}
