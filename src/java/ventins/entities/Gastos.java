/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventins.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lorena
 */
@Entity
@Table(name = "gastos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gastos.findAll", query = "SELECT g FROM Gastos g")
    , @NamedQuery(name = "Gastos.findByGasId", query = "SELECT g FROM Gastos g WHERE g.gasId = :gasId")
    , @NamedQuery(name = "Gastos.findByGasFecha", query = "SELECT g FROM Gastos g WHERE g.gasFecha = :gasFecha")
    , @NamedQuery(name = "Gastos.findByGasFac", query = "SELECT g FROM Gastos g WHERE g.gasFac = :gasFac")})
public class Gastos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "gas_id")
    private BigDecimal gasId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gas_fecha")
    @Temporal(TemporalType.DATE)
    private Date gasFecha;
    @Column(name = "gas_fac")
    private Long gasFac;
    @JoinColumn(name = "bat_conc_gasto", referencedColumnName = "bat_id")
    @ManyToOne(optional = false)
    private BasicaTipo batConcGasto;
    @JoinColumn(name = "usu_id_gas", referencedColumnName = "usu_id")
    @ManyToOne(optional = false)
    private Usuarios usuIdGas;
    @JoinColumn(name = "usu_id_gen", referencedColumnName = "usu_id")
    @ManyToOne(optional = false)
    private Usuarios usuIdGen;

    public Gastos() {
    }

    public Gastos(BigDecimal gasId) {
        this.gasId = gasId;
    }

    public Gastos(BigDecimal gasId, Date gasFecha) {
        this.gasId = gasId;
        this.gasFecha = gasFecha;
    }

    public BigDecimal getGasId() {
        return gasId;
    }

    public void setGasId(BigDecimal gasId) {
        this.gasId = gasId;
    }

    public Date getGasFecha() {
        return gasFecha;
    }

    public void setGasFecha(Date gasFecha) {
        this.gasFecha = gasFecha;
    }

    public Long getGasFac() {
        return gasFac;
    }

    public void setGasFac(Long gasFac) {
        this.gasFac = gasFac;
    }

    public BasicaTipo getBatConcGasto() {
        return batConcGasto;
    }

    public void setBatConcGasto(BasicaTipo batConcGasto) {
        this.batConcGasto = batConcGasto;
    }

    public Usuarios getUsuIdGas() {
        return usuIdGas;
    }

    public void setUsuIdGas(Usuarios usuIdGas) {
        this.usuIdGas = usuIdGas;
    }

    public Usuarios getUsuIdGen() {
        return usuIdGen;
    }

    public void setUsuIdGen(Usuarios usuIdGen) {
        this.usuIdGen = usuIdGen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gasId != null ? gasId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gastos)) {
            return false;
        }
        Gastos other = (Gastos) object;
        if ((this.gasId == null && other.gasId != null) || (this.gasId != null && !this.gasId.equals(other.gasId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ventins.entities.Gastos[ gasId=" + gasId + " ]";
    }
    
}
