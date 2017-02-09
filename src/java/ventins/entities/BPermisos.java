/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventins.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lorena
 */
@Entity
@Table(name = "b_permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BPermisos.findAll", query = "SELECT b FROM BPermisos b")
    , @NamedQuery(name = "BPermisos.findByPermId", query = "SELECT b FROM BPermisos b WHERE b.permId = :permId")
    , @NamedQuery(name = "BPermisos.findByPerId", query = "SELECT b FROM BPermisos b WHERE b.perId = :perId")
    , @NamedQuery(name = "BPermisos.findByMenId", query = "SELECT b FROM BPermisos b WHERE b.menId = :menId")})
public class BPermisos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "perm_id")
    private Long permId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "per_id")
    private BigInteger perId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "men_id")
    private long menId;

    public BPermisos() {
    }

    public BPermisos(Long permId) {
        this.permId = permId;
    }

    public BPermisos(Long permId, BigInteger perId, long menId) {
        this.permId = permId;
        this.perId = perId;
        this.menId = menId;
    }

    public Long getPermId() {
        return permId;
    }

    public void setPermId(Long permId) {
        this.permId = permId;
    }

    public BigInteger getPerId() {
        return perId;
    }

    public void setPerId(BigInteger perId) {
        this.perId = perId;
    }

    public long getMenId() {
        return menId;
    }

    public void setMenId(long menId) {
        this.menId = menId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permId != null ? permId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BPermisos)) {
            return false;
        }
        BPermisos other = (BPermisos) object;
        if ((this.permId == null && other.permId != null) || (this.permId != null && !this.permId.equals(other.permId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ventins.entities.BPermisos[ permId=" + permId + " ]";
    }
    
}
