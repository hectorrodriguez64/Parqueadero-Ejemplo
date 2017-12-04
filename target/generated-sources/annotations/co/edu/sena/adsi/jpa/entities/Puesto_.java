package co.edu.sena.adsi.jpa.entities;

import co.edu.sena.adsi.jpa.entities.Carro;
import co.edu.sena.adsi.jpa.entities.Parqueadero;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-04T10:54:12")
@StaticMetamodel(Puesto.class)
public class Puesto_ { 

    public static volatile SingularAttribute<Puesto, Parqueadero> idParqueadero;
    public static volatile SingularAttribute<Puesto, Carro> idCarro;
    public static volatile SingularAttribute<Puesto, Integer> numeroPuesto;
    public static volatile SingularAttribute<Puesto, Integer> id;

}