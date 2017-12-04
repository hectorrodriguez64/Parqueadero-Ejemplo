package co.edu.sena.adsi.jpa.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-04T12:59:25")
@StaticMetamodel(Parqueadero.class)
public class Parqueadero_ { 

    public static volatile SingularAttribute<Parqueadero, Double> tarifa;
    public static volatile SingularAttribute<Parqueadero, Integer> puestos;
    public static volatile SingularAttribute<Parqueadero, Integer> id;
    public static volatile SingularAttribute<Parqueadero, Double> caja;
    public static volatile SingularAttribute<Parqueadero, Double> valorPagar;
    public static volatile SingularAttribute<Parqueadero, Date> horaActual;
    public static volatile SingularAttribute<Parqueadero, Boolean> abierto;

}