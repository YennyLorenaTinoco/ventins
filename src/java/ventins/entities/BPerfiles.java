/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventins.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lorena
 */
@Entity
@Table(name = "b_perfiles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BPerfiles.findAll", query = "SELECT b FROM BPerfiles b")
    , @NamedQuery(name = "BPerfiles.findByPerId", query = "SELECT b FROM BPerfiles b WHERE b.perId = :perId")
    , @NamedQuery(name = "BPerfiles.findByPerNombre", query = "SELECT b FROM BPerfiles b WHERE b.perNombre = :perNombre")
    , @NamedQuery(name = "BPerfiles.findByPerFechaReg", query = "SELECT b FROM BPerfiles b WHERE b.perFechaReg = :perFechaReg")})
public class BPerfiles implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "per_id")
    private BigDecimal perId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "per_nombre")
    private String perNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "per_fecha_reg")
    @Temporal(TemporalType.DATE)
    private Date perFechaReg;
    @OneToMany(mappedBy = "perId")
    private Collection<Usuarios> usuariosCollection;

    public BPerfiles() {
    }

    public BPerfiles(BigDecimal perId) {
        this.perId = perId;
    }

    public BPerfiles(BigDecimal perId, String perNombre, Date perFechaReg) {
        this.perId = perId;
        this.perNombre = perNombre;
        this.perFechaReg = perFechaReg;
    }

    public BigDecimal getPerId() {
        return perId;
    }

    public void setPerId(BigDecimal perId) {
        this.perId = perId;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public Date getPerFechaReg() {
        return perFechaReg;
    }

    public void setPerFechaReg(Date perFechaReg) {
        this.perFechaReg = perFechaReg;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BPerfiles)) {
            return false;
        }
        BPerfiles other = (BPerfiles) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ventins.entities.BPerfiles[ perId=" + perId + " ]";
    }
    
}
