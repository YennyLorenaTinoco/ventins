/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventins.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lorena
 */
@Embeddable
public class InventarioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "inv_id")
    private long invId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "inv_lote")
    private String invLote;

    public InventarioPK() {
    }

    public InventarioPK(long invId, String invLote) {
        this.invId = invId;
        this.invLote = invLote;
    }

    public long getInvId() {
        return invId;
    }

    public void setInvId(long invId) {
        this.invId = invId;
    }

    public String getInvLote() {
        return invLote;
    }

    public void setInvLote(String invLote) {
        this.invLote = invLote;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) invId;
        hash += (invLote != null ? invLote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioPK)) {
            return false;
        }
        InventarioPK other = (InventarioPK) object;
        if (this.invId != other.invId) {
            return false;
        }
        if ((this.invLote == null && other.invLote != null) || (this.invLote != null && !this.invLote.equals(other.invLote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ventins.entities.InventarioPK[ invId=" + invId + ", invLote=" + invLote + " ]";
    }
    
}
