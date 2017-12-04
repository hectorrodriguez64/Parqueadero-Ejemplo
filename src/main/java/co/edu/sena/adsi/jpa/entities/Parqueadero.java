/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adsi1261718
 */
@Entity
@Table(name = "parqueadero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parqueadero.findAll", query = "SELECT p FROM Parqueadero p")
    , @NamedQuery(name = "Parqueadero.findById", query = "SELECT p FROM Parqueadero p WHERE p.id = :id")
    , @NamedQuery(name = "Parqueadero.findByTarifa", query = "SELECT p FROM Parqueadero p WHERE p.tarifa = :tarifa")
    , @NamedQuery(name = "Parqueadero.findByHoraActual", query = "SELECT p FROM Parqueadero p WHERE p.horaActual = :horaActual")
    , @NamedQuery(name = "Parqueadero.findByAbierto", query = "SELECT p FROM Parqueadero p WHERE p.abierto = :abierto")
    , @NamedQuery(name = "Parqueadero.findByCaja", query = "SELECT p FROM Parqueadero p WHERE p.caja = :caja")
    , @NamedQuery(name = "Parqueadero.findByValorPagar", query = "SELECT p FROM Parqueadero p WHERE p.valorPagar = :valorPagar")})
public class Parqueadero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarifa")
    private double tarifa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_actual")
    @Temporal(TemporalType.TIME)
    private Date horaActual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "abierto")
    private boolean abierto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "caja")
    private double caja;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_pagar")
    private Double valorPagar;

    public Parqueadero() {
    }

    public Parqueadero(Integer id) {
        this.id = id;
    }

    public Parqueadero(Integer id, double tarifa, Date horaActual, boolean abierto, double caja) {
        this.id = id;
        this.tarifa = tarifa;
        this.horaActual = horaActual;
        this.abierto = abierto;
        this.caja = caja;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public Date getHoraActual() {
        return horaActual;
    }

    public void setHoraActual(Date horaActual) {
        this.horaActual = horaActual;
    }

    public boolean getAbierto() {
        return abierto;
    }

    public void setAbierto(boolean abierto) {
        this.abierto = abierto;
    }

    public double getCaja() {
        return caja;
    }

    public void setCaja(double caja) {
        this.caja = caja;
    }

    public Double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(Double valorPagar) {
        this.valorPagar = valorPagar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parqueadero)) {
            return false;
        }
        Parqueadero other = (Parqueadero) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.adsi.jpa.entities.Parqueadero[ id=" + id + " ]";
    }
    
}
