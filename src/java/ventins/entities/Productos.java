/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventins.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lorena
 */
@Entity
@Table(name = "productos", catalog = "ventins", schema = "ventins")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")
    , @NamedQuery(name = "Productos.findByProdId", query = "SELECT p FROM Productos p WHERE p.prodId = :prodId")
    , @NamedQuery(name = "Productos.findByProdNombre", query = "SELECT p FROM Productos p WHERE p.prodNombre = :prodNombre")
    , @NamedQuery(name = "Productos.findByProdValorVenta", query = "SELECT p FROM Productos p WHERE p.prodValorVenta = :prodValorVenta")
    , @NamedQuery(name = "Productos.findByProdCant", query = "SELECT p FROM Productos p WHERE p.prodCant = :prodCant")
    , @NamedQuery(name = "Productos.findByProdCostoTotal", query = "SELECT p FROM Productos p WHERE p.prodCostoTotal = :prodCostoTotal")
    , @NamedQuery(name = "Productos.findByProdTipoMedida", query = "SELECT p FROM Productos p WHERE p.prodTipoMedida = :prodTipoMedida")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prod_id")
    private Long prodId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "prod_nombre")
    private String prodNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prod_valor_venta")
    private long prodValorVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prod_cant")
    private long prodCant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prod_costo_total")
    private long prodCostoTotal;
    @Size(max = 2)
    @Column(name = "prod_tipo_medida")
    private String prodTipoMedida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prodId")
    private List<FacturasComprasDet> facturasComprasDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prodId")
    private List<VentaDetalle> ventaDetalleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prodId")
    private List<Inventario> inventarioList;
    @JoinColumn(name = "prod_codigo", referencedColumnName = "bat_id")
    @ManyToOne(optional = false)
    private BasicaTipo prodCodigo;

    public Productos() {
    }

    public Productos(Long prodId) {
        this.prodId = prodId;
    }

    public Productos(Long prodId, String prodNombre, long prodValorVenta, long prodCant, long prodCostoTotal) {
        this.prodId = prodId;
        this.prodNombre = prodNombre;
        this.prodValorVenta = prodValorVenta;
        this.prodCant = prodCant;
        this.prodCostoTotal = prodCostoTotal;
    }

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public String getProdNombre() {
        return prodNombre;
    }

    public void setProdNombre(String prodNombre) {
        this.prodNombre = prodNombre;
    }

    public long getProdValorVenta() {
        return prodValorVenta;
    }

    public void setProdValorVenta(long prodValorVenta) {
        this.prodValorVenta = prodValorVenta;
    }

    public long getProdCant() {
        return prodCant;
    }

    public void setProdCant(long prodCant) {
        this.prodCant = prodCant;
    }

    public long getProdCostoTotal() {
        return prodCostoTotal;
    }

    public void setProdCostoTotal(long prodCostoTotal) {
        this.prodCostoTotal = prodCostoTotal;
    }

    public String getProdTipoMedida() {
        return prodTipoMedida;
    }

    public void setProdTipoMedida(String prodTipoMedida) {
        this.prodTipoMedida = prodTipoMedida;
    }

    @XmlTransient
    public List<FacturasComprasDet> getFacturasComprasDetList() {
        return facturasComprasDetList;
    }

    public void setFacturasComprasDetList(List<FacturasComprasDet> facturasComprasDetList) {
        this.facturasComprasDetList = facturasComprasDetList;
    }

    @XmlTransient
    public List<VentaDetalle> getVentaDetalleList() {
        return ventaDetalleList;
    }

    public void setVentaDetalleList(List<VentaDetalle> ventaDetalleList) {
        this.ventaDetalleList = ventaDetalleList;
    }

    @XmlTransient
    public List<Inventario> getInventarioList() {
        return inventarioList;
    }

    public void setInventarioList(List<Inventario> inventarioList) {
        this.inventarioList = inventarioList;
    }

    public BasicaTipo getProdCodigo() {
        return prodCodigo;
    }

    public void setProdCodigo(BasicaTipo prodCodigo) {
        this.prodCodigo = prodCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodId != null ? prodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.prodId == null && other.prodId != null) || (this.prodId != null && !this.prodId.equals(other.prodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ventins.entities.Productos[ prodId=" + prodId + " ]";
    }
    
}
