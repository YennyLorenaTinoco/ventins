/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventins.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "inventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i")
    , @NamedQuery(name = "Inventario.findByInvId", query = "SELECT i FROM Inventario i WHERE i.inventarioPK.invId = :invId")
    , @NamedQuery(name = "Inventario.findByInvLote", query = "SELECT i FROM Inventario i WHERE i.inventarioPK.invLote = :invLote")
    , @NamedQuery(name = "Inventario.findByInvFechaVen", query = "SELECT i FROM Inventario i WHERE i.invFechaVen = :invFechaVen")
    , @NamedQuery(name = "Inventario.findByInvCantidad", query = "SELECT i FROM Inventario i WHERE i.invCantidad = :invCantidad")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InventarioPK inventarioPK;
    @Column(name = "inv_fecha_ven")
    @Temporal(TemporalType.DATE)
    private Date invFechaVen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inv_cantidad")
    private long invCantidad;
    @JoinColumn(name = "bat_grupo", referencedColumnName = "bat_id")
    @ManyToOne(optional = false)
    private BasicaTipo batGrupo;
    @JoinColumn(name = "bat_nivel", referencedColumnName = "bat_id")
    @ManyToOne(optional = false)
    private BasicaTipo batNivel;
    @JoinColumn(name = "bat_estante", referencedColumnName = "bat_id")
    @ManyToOne(optional = false)
    private BasicaTipo batEstante;
    @JoinColumn(name = "bat_uni", referencedColumnName = "bat_id")
    @ManyToOne(optional = false)
    private BasicaTipo batUni;
    @JoinColumn(name = "prod_id", referencedColumnName = "prod_id")
    @ManyToOne(optional = false)
    private Productos prodId;

    public Inventario() {
    }

    public Inventario(InventarioPK inventarioPK) {
        this.inventarioPK = inventarioPK;
    }

    public Inventario(InventarioPK inventarioPK, long invCantidad) {
        this.inventarioPK = inventarioPK;
        this.invCantidad = invCantidad;
    }

    public Inventario(long invId, String invLote) {
        this.inventarioPK = new InventarioPK(invId, invLote);
    }

    public InventarioPK getInventarioPK() {
        return inventarioPK;
    }

    public void setInventarioPK(InventarioPK inventarioPK) {
        this.inventarioPK = inventarioPK;
    }

    public Date getInvFechaVen() {
        return invFechaVen;
    }

    public void setInvFechaVen(Date invFechaVen) {
        this.invFechaVen = invFechaVen;
    }

    public long getInvCantidad() {
        return invCantidad;
    }

    public void setInvCantidad(long invCantidad) {
        this.invCantidad = invCantidad;
    }

    public BasicaTipo getBatGrupo() {
        return batGrupo;
    }

    public void setBatGrupo(BasicaTipo batGrupo) {
        this.batGrupo = batGrupo;
    }

    public BasicaTipo getBatNivel() {
        return batNivel;
    }

    public void setBatNivel(BasicaTipo batNivel) {
        this.batNivel = batNivel;
    }

    public BasicaTipo getBatEstante() {
        return batEstante;
    }

    public void setBatEstante(BasicaTipo batEstante) {
        this.batEstante = batEstante;
    }

    public BasicaTipo getBatUni() {
        return batUni;
    }

    public void setBatUni(BasicaTipo batUni) {
        this.batUni = batUni;
    }

    public Productos getProdId() {
        return prodId;
    }

    public void setProdId(Productos prodId) {
        this.prodId = prodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventarioPK != null ? inventarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.inventarioPK == null && other.inventarioPK != null) || (this.inventarioPK != null && !this.inventarioPK.equals(other.inventarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ventins.entities.Inventario[ inventarioPK=" + inventarioPK + " ]";
    }
    
}
