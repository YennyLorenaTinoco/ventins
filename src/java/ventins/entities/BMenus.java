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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lorena
 */
@Entity
@Table(name = "b_menus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BMenus.findAll", query = "SELECT b FROM BMenus b")
    , @NamedQuery(name = "BMenus.findByMenId", query = "SELECT b FROM BMenus b WHERE b.menId = :menId")
    , @NamedQuery(name = "BMenus.findByMenPadre", query = "SELECT b FROM BMenus b WHERE b.menPadre = :menPadre")
    , @NamedQuery(name = "BMenus.findByMenNombre", query = "SELECT b FROM BMenus b WHERE b.menNombre = :menNombre")
    , @NamedQuery(name = "BMenus.findByMenOrden", query = "SELECT b FROM BMenus b WHERE b.menOrden = :menOrden")})
public class BMenus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "men_id")
    private Long menId;
    @Column(name = "men_padre")
    private Long menPadre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "men_nombre")
    private String menNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "men_orden")
    private BigInteger menOrden;

    public BMenus() {
    }

    public BMenus(Long menId) {
        this.menId = menId;
    }

    public BMenus(Long menId, String menNombre, BigInteger menOrden) {
        this.menId = menId;
        this.menNombre = menNombre;
        this.menOrden = menOrden;
    }

    public Long getMenId() {
        return menId;
    }

    public void setMenId(Long menId) {
        this.menId = menId;
    }

    public Long getMenPadre() {
        return menPadre;
    }

    public void setMenPadre(Long menPadre) {
        this.menPadre = menPadre;
    }

    public String getMenNombre() {
        return menNombre;
    }

    public void setMenNombre(String menNombre) {
        this.menNombre = menNombre;
    }

    public BigInteger getMenOrden() {
        return menOrden;
    }

    public void setMenOrden(BigInteger menOrden) {
        this.menOrden = menOrden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menId != null ? menId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BMenus)) {
            return false;
        }
        BMenus other = (BMenus) object;
        if ((this.menId == null && other.menId != null) || (this.menId != null && !this.menId.equals(other.menId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ventins.entities.BMenus[ menId=" + menId + " ]";
    }
    
}
