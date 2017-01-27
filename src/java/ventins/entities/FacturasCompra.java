/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventins.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "facturas_compra", catalog = "ventins", schema = "ventins")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturasCompra.findAll", query = "SELECT f FROM FacturasCompra f")
    , @NamedQuery(name = "FacturasCompra.findByFacCompraId", query = "SELECT f FROM FacturasCompra f WHERE f.facCompraId = :facCompraId")
    , @NamedQuery(name = "FacturasCompra.findByNumFacCompra", query = "SELECT f FROM FacturasCompra f WHERE f.numFacCompra = :numFacCompra")
    , @NamedQuery(name = "FacturasCompra.findByFacComCostoVenta", query = "SELECT f FROM FacturasCompra f WHERE f.facComCostoVenta = :facComCostoVenta")
    , @NamedQuery(name = "FacturasCompra.findByFechaRegCompra", query = "SELECT f FROM FacturasCompra f WHERE f.fechaRegCompra = :fechaRegCompra")
    , @NamedQuery(name = "FacturasCompra.findByFechaVenCompra", query = "SELECT f FROM FacturasCompra f WHERE f.fechaVenCompra = :fechaVenCompra")
    , @NamedQuery(name = "FacturasCompra.findByFechaPagoCompra", query = "SELECT f FROM FacturasCompra f WHERE f.fechaPagoCompra = :fechaPagoCompra")
    , @NamedQuery(name = "FacturasCompra.findByEstadoCompra", query = "SELECT f FROM FacturasCompra f WHERE f.estadoCompra = :estadoCompra")})
public class FacturasCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "fac_compra_id")
    private Long facCompraId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_fac_compra")
    private long numFacCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fac_com_costo_venta")
    private long facComCostoVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_reg_compra")
    @Temporal(TemporalType.DATE)
    private Date fechaRegCompra;
    @Column(name = "fecha_ven_compra")
    @Temporal(TemporalType.DATE)
    private Date fechaVenCompra;
    @Column(name = "fecha_pago_compra")
    @Temporal(TemporalType.DATE)
    private Date fechaPagoCompra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "estado_compra")
    private String estadoCompra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facCompraId")
    private List<FacturasComprasDet> facturasComprasDetList;
    @JoinColumn(name = "bat_conc_compra", referencedColumnName = "bat_id")
    @ManyToOne(optional = false)
    private BasicaTipo batConcCompra;
    @JoinColumn(name = "prov_id", referencedColumnName = "prov_id")
    @ManyToOne(optional = false)
    private Proveedores provId;
    @JoinColumn(name = "usu_reg_fac_compra", referencedColumnName = "usu_id")
    @ManyToOne(optional = false)
    private Usuarios usuRegFacCompra;
    @JoinColumn(name = "usu_canc_fac_compra", referencedColumnName = "usu_id")
    @ManyToOne(optional = false)
    private Usuarios usuCancFacCompra;

    public FacturasCompra() {
    }

    public FacturasCompra(Long facCompraId) {
        this.facCompraId = facCompraId;
    }

    public FacturasCompra(Long facCompraId, long numFacCompra, long facComCostoVenta, Date fechaRegCompra, String estadoCompra) {
        this.facCompraId = facCompraId;
        this.numFacCompra = numFacCompra;
        this.facComCostoVenta = facComCostoVenta;
        this.fechaRegCompra = fechaRegCompra;
        this.estadoCompra = estadoCompra;
    }

    public Long getFacCompraId() {
        return facCompraId;
    }

    public void setFacCompraId(Long facCompraId) {
        this.facCompraId = facCompraId;
    }

    public long getNumFacCompra() {
        return numFacCompra;
    }

    public void setNumFacCompra(long numFacCompra) {
        this.numFacCompra = numFacCompra;
    }

    public long getFacComCostoVenta() {
        return facComCostoVenta;
    }

    public void setFacComCostoVenta(long facComCostoVenta) {
        this.facComCostoVenta = facComCostoVenta;
    }

    public Date getFechaRegCompra() {
        return fechaRegCompra;
    }

    public void setFechaRegCompra(Date fechaRegCompra) {
        this.fechaRegCompra = fechaRegCompra;
    }

    public Date getFechaVenCompra() {
        return fechaVenCompra;
    }

    public void setFechaVenCompra(Date fechaVenCompra) {
        this.fechaVenCompra = fechaVenCompra;
    }

    public Date getFechaPagoCompra() {
        return fechaPagoCompra;
    }

    public void setFechaPagoCompra(Date fechaPagoCompra) {
        this.fechaPagoCompra = fechaPagoCompra;
    }

    public String getEstadoCompra() {
        return estadoCompra;
    }

    public void setEstadoCompra(String estadoCompra) {
        this.estadoCompra = estadoCompra;
    }

    @XmlTransient
    public List<FacturasComprasDet> getFacturasComprasDetList() {
        return facturasComprasDetList;
    }

    public void setFacturasComprasDetList(List<FacturasComprasDet> facturasComprasDetList) {
        this.facturasComprasDetList = facturasComprasDetList;
    }

    public BasicaTipo getBatConcCompra() {
        return batConcCompra;
    }

    public void setBatConcCompra(BasicaTipo batConcCompra) {
        this.batConcCompra = batConcCompra;
    }

    public Proveedores getProvId() {
        return provId;
    }

    public void setProvId(Proveedores provId) {
        this.provId = provId;
    }

    public Usuarios getUsuRegFacCompra() {
        return usuRegFacCompra;
    }

    public void setUsuRegFacCompra(Usuarios usuRegFacCompra) {
        this.usuRegFacCompra = usuRegFacCompra;
    }

    public Usuarios getUsuCancFacCompra() {
        return usuCancFacCompra;
    }

    public void setUsuCancFacCompra(Usuarios usuCancFacCompra) {
        this.usuCancFacCompra = usuCancFacCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facCompraId != null ? facCompraId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturasCompra)) {
            return false;
        }
        FacturasCompra other = (FacturasCompra) object;
        if ((this.facCompraId == null && other.facCompraId != null) || (this.facCompraId != null && !this.facCompraId.equals(other.facCompraId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ventins.entities.FacturasCompra[ facCompraId=" + facCompraId + " ]";
    }
    
}
