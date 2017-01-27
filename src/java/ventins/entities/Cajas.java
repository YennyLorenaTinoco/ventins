/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventins.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lorena
 */
@Entity
@Table(name = "cajas", catalog = "ventins", schema = "ventins")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cajas.findAll", query = "SELECT c FROM Cajas c")
    , @NamedQuery(name = "Cajas.findByCajaId", query = "SELECT c FROM Cajas c WHERE c.cajaId = :cajaId")
    , @NamedQuery(name = "Cajas.findByCajaNombre", query = "SELECT c FROM Cajas c WHERE c.cajaNombre = :cajaNombre")
    , @NamedQuery(name = "Cajas.findByCajaCodigo", query = "SELECT c FROM Cajas c WHERE c.cajaCodigo = :cajaCodigo")
    , @NamedQuery(name = "Cajas.findByCajaValorBase", query = "SELECT c FROM Cajas c WHERE c.cajaValorBase = :cajaValorBase")})
public class Cajas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "caja_id")
    private Long cajaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "caja_nombre")
    private String cajaNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "caja_codigo")
    private String cajaCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "caja_valor_base")
    private String cajaValorBase;
    @JoinColumn(name = "usu_id", referencedColumnName = "usu_id")
    @ManyToOne(optional = false)
    private Usuarios usuId;

    public Cajas() {
    }

    public Cajas(Long cajaId) {
        this.cajaId = cajaId;
    }

    public Cajas(Long cajaId, String cajaNombre, String cajaCodigo, String cajaValorBase) {
        this.cajaId = cajaId;
        this.cajaNombre = cajaNombre;
        this.cajaCodigo = cajaCodigo;
        this.cajaValorBase = cajaValorBase;
    }

    public Long getCajaId() {
        return cajaId;
    }

    public void setCajaId(Long cajaId) {
        this.cajaId = cajaId;
    }

    public String getCajaNombre() {
        return cajaNombre;
    }

    public void setCajaNombre(String cajaNombre) {
        this.cajaNombre = cajaNombre;
    }

    public String getCajaCodigo() {
        return cajaCodigo;
    }

    public void setCajaCodigo(String cajaCodigo) {
        this.cajaCodigo = cajaCodigo;
    }

    public String getCajaValorBase() {
        return cajaValorBase;
    }

    public void setCajaValorBase(String cajaValorBase) {
        this.cajaValorBase = cajaValorBase;
    }

    public Usuarios getUsuId() {
        return usuId;
    }

    public void setUsuId(Usuarios usuId) {
        this.usuId = usuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cajaId != null ? cajaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cajas)) {
            return false;
        }
        Cajas other = (Cajas) object;
        if ((this.cajaId == null && other.cajaId != null) || (this.cajaId != null && !this.cajaId.equals(other.cajaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ventins.entities.Cajas[ cajaId=" + cajaId + " ]";
    }
    
}
