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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "facturas_compras_det", catalog = "ventins", schema = "ventins")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturasComprasDet.findAll", query = "SELECT f FROM FacturasComprasDet f")
    , @NamedQuery(name = "FacturasComprasDet.findByFacDetId", query = "SELECT f FROM FacturasComprasDet f WHERE f.facDetId = :facDetId")
    , @NamedQuery(name = "FacturasComprasDet.findByFacDetCantProd", query = "SELECT f FROM FacturasComprasDet f WHERE f.facDetCantProd = :facDetCantProd")
    , @NamedQuery(name = "FacturasComprasDet.findByFacDetVlorUni", query = "SELECT f FROM FacturasComprasDet f WHERE f.facDetVlorUni = :facDetVlorUni")})
public class FacturasComprasDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "fac_det_id")
    private Long facDetId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fac_det_cant_prod")
    private long facDetCantProd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fac_det_vlor_uni")
    private BigInteger facDetVlorUni;
    @JoinColumn(name = "fac_compra_id", referencedColumnName = "fac_compra_id")
    @ManyToOne(optional = false)
    private FacturasCompra facCompraId;
    @JoinColumn(name = "prod_id", referencedColumnName = "prod_id")
    @ManyToOne(optional = false)
    private Productos prodId;

    public FacturasComprasDet() {
    }

    public FacturasComprasDet(Long facDetId) {
        this.facDetId = facDetId;
    }

    public FacturasComprasDet(Long facDetId, long facDetCantProd, BigInteger facDetVlorUni) {
        this.facDetId = facDetId;
        this.facDetCantProd = facDetCantProd;
        this.facDetVlorUni = facDetVlorUni;
    }

    public Long getFacDetId() {
        return facDetId;
    }

    public void setFacDetId(Long facDetId) {
        this.facDetId = facDetId;
    }

    public long getFacDetCantProd() {
        return facDetCantProd;
    }

    public void setFacDetCantProd(long facDetCantProd) {
        this.facDetCantProd = facDetCantProd;
    }

    public BigInteger getFacDetVlorUni() {
        return facDetVlorUni;
    }

    public void setFacDetVlorUni(BigInteger facDetVlorUni) {
        this.facDetVlorUni = facDetVlorUni;
    }

    public FacturasCompra getFacCompraId() {
        return facCompraId;
    }

    public void setFacCompraId(FacturasCompra facCompraId) {
        this.facCompraId = facCompraId;
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
        hash += (facDetId != null ? facDetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturasComprasDet)) {
            return false;
        }
        FacturasComprasDet other = (FacturasComprasDet) object;
        if ((this.facDetId == null && other.facDetId != null) || (this.facDetId != null && !this.facDetId.equals(other.facDetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ventins.entities.FacturasComprasDet[ facDetId=" + facDetId + " ]";
    }
    
}
