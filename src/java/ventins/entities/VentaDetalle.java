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
@Table(name = "venta_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaDetalle.findAll", query = "SELECT v FROM VentaDetalle v")
    , @NamedQuery(name = "VentaDetalle.findByVentaDetId", query = "SELECT v FROM VentaDetalle v WHERE v.ventaDetId = :ventaDetId")
    , @NamedQuery(name = "VentaDetalle.findByCantProd", query = "SELECT v FROM VentaDetalle v WHERE v.cantProd = :cantProd")
    , @NamedQuery(name = "VentaDetalle.findByValorUni", query = "SELECT v FROM VentaDetalle v WHERE v.valorUni = :valorUni")})
public class VentaDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "venta_det_id")
    private Long ventaDetId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "cant_prod")
    private String cantProd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_uni")
    private long valorUni;
    @JoinColumn(name = "prod_id", referencedColumnName = "prod_id")
    @ManyToOne(optional = false)
    private Productos prodId;
    @JoinColumn(name = "venta_id", referencedColumnName = "venta_id")
    @ManyToOne(optional = false)
    private Ventas ventaId;

    public VentaDetalle() {
    }

    public VentaDetalle(Long ventaDetId) {
        this.ventaDetId = ventaDetId;
    }

    public VentaDetalle(Long ventaDetId, String cantProd, long valorUni) {
        this.ventaDetId = ventaDetId;
        this.cantProd = cantProd;
        this.valorUni = valorUni;
    }

    public Long getVentaDetId() {
        return ventaDetId;
    }

    public void setVentaDetId(Long ventaDetId) {
        this.ventaDetId = ventaDetId;
    }

    public String getCantProd() {
        return cantProd;
    }

    public void setCantProd(String cantProd) {
        this.cantProd = cantProd;
    }

    public long getValorUni() {
        return valorUni;
    }

    public void setValorUni(long valorUni) {
        this.valorUni = valorUni;
    }

    public Productos getProdId() {
        return prodId;
    }

    public void setProdId(Productos prodId) {
        this.prodId = prodId;
    }

    public Ventas getVentaId() {
        return ventaId;
    }

    public void setVentaId(Ventas ventaId) {
        this.ventaId = ventaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventaDetId != null ? ventaDetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaDetalle)) {
            return false;
        }
        VentaDetalle other = (VentaDetalle) object;
        if ((this.ventaDetId == null && other.ventaDetId != null) || (this.ventaDetId != null && !this.ventaDetId.equals(other.ventaDetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ventins.entities.VentaDetalle[ ventaDetId=" + ventaDetId + " ]";
    }
    
}
