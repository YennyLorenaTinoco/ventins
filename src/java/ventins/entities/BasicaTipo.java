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
import javax.persistence.JoinColumns;
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
@Table(name = "basica_tipo", catalog = "ventins", schema = "ventins")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BasicaTipo.findAll", query = "SELECT b FROM BasicaTipo b")
    , @NamedQuery(name = "BasicaTipo.findByBatId", query = "SELECT b FROM BasicaTipo b WHERE b.batId = :batId")
    , @NamedQuery(name = "BasicaTipo.findByBatNombre", query = "SELECT b FROM BasicaTipo b WHERE b.batNombre = :batNombre")
    , @NamedQuery(name = "BasicaTipo.findByBatPadre", query = "SELECT b FROM BasicaTipo b WHERE b.batPadre = :batPadre")
    , @NamedQuery(name = "BasicaTipo.findByBatCodigo", query = "SELECT b FROM BasicaTipo b WHERE b.batCodigo = :batCodigo")
    , @NamedQuery(name = "BasicaTipo.findByBatDescriptor1", query = "SELECT b FROM BasicaTipo b WHERE b.batDescriptor1 = :batDescriptor1")
    , @NamedQuery(name = "BasicaTipo.findByBatDescriptor2", query = "SELECT b FROM BasicaTipo b WHERE b.batDescriptor2 = :batDescriptor2")})
public class BasicaTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "bat_id")
    private Long batId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "bat_nombre")
    private String batNombre;
    @Column(name = "bat_padre")
    private Long batPadre;
    @Size(max = 255)
    @Column(name = "bat_codigo")
    private String batCodigo;
    @Size(max = 255)
    @Column(name = "bat_descriptor1")
    private String batDescriptor1;
    @Size(max = 255)
    @Column(name = "bat_descriptor2")
    private String batDescriptor2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batTipoDoc")
    private List<Usuarios> usuariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batConcGasto")
    private List<Gastos> gastosList;
    @OneToMany(mappedBy = "batPais")
    private List<Proveedores> proveedoresList;
    @OneToMany(mappedBy = "batMun")
    private List<Proveedores> proveedoresList1;
    @OneToMany(mappedBy = "batDepto")
    private List<Proveedores> proveedoresList2;
    @JoinColumn(name = "btl_id", referencedColumnName = "btl_id")
    @ManyToOne(optional = false)
    private BasicaTabla btlId;
    @JoinColumns({
        @JoinColumn(name = "inv_id", referencedColumnName = "inv_id")
        , @JoinColumn(name = "inv_lote", referencedColumnName = "inv_lote")})
    @ManyToOne(optional = false)
    private Inventario inventario;
    @OneToMany(mappedBy = "batTipoDoc")
    private List<Clientes> clientesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batPais")
    private List<Empresa> empresaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batDepto")
    private List<Empresa> empresaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batMun")
    private List<Empresa> empresaList2;
    @OneToMany(mappedBy = "batBarrio")
    private List<Empresa> empresaList3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batConcCompra")
    private List<FacturasCompra> facturasCompraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batGrupo")
    private List<Inventario> inventarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batNivel")
    private List<Inventario> inventarioList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batEstante")
    private List<Inventario> inventarioList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batUni")
    private List<Inventario> inventarioList3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prodCodigo")
    private List<Productos> productosList;

    public BasicaTipo() {
    }

    public BasicaTipo(Long batId) {
        this.batId = batId;
    }

    public BasicaTipo(Long batId, String batNombre) {
        this.batId = batId;
        this.batNombre = batNombre;
    }

    public Long getBatId() {
        return batId;
    }

    public void setBatId(Long batId) {
        this.batId = batId;
    }

    public String getBatNombre() {
        return batNombre;
    }

    public void setBatNombre(String batNombre) {
        this.batNombre = batNombre;
    }

    public Long getBatPadre() {
        return batPadre;
    }

    public void setBatPadre(Long batPadre) {
        this.batPadre = batPadre;
    }

    public String getBatCodigo() {
        return batCodigo;
    }

    public void setBatCodigo(String batCodigo) {
        this.batCodigo = batCodigo;
    }

    public String getBatDescriptor1() {
        return batDescriptor1;
    }

    public void setBatDescriptor1(String batDescriptor1) {
        this.batDescriptor1 = batDescriptor1;
    }

    public String getBatDescriptor2() {
        return batDescriptor2;
    }

    public void setBatDescriptor2(String batDescriptor2) {
        this.batDescriptor2 = batDescriptor2;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @XmlTransient
    public List<Gastos> getGastosList() {
        return gastosList;
    }

    public void setGastosList(List<Gastos> gastosList) {
        this.gastosList = gastosList;
    }

    @XmlTransient
    public List<Proveedores> getProveedoresList() {
        return proveedoresList;
    }

    public void setProveedoresList(List<Proveedores> proveedoresList) {
        this.proveedoresList = proveedoresList;
    }

    @XmlTransient
    public List<Proveedores> getProveedoresList1() {
        return proveedoresList1;
    }

    public void setProveedoresList1(List<Proveedores> proveedoresList1) {
        this.proveedoresList1 = proveedoresList1;
    }

    @XmlTransient
    public List<Proveedores> getProveedoresList2() {
        return proveedoresList2;
    }

    public void setProveedoresList2(List<Proveedores> proveedoresList2) {
        this.proveedoresList2 = proveedoresList2;
    }

    public BasicaTabla getBtlId() {
        return btlId;
    }

    public void setBtlId(BasicaTabla btlId) {
        this.btlId = btlId;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    @XmlTransient
    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
    }

    @XmlTransient
    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
    }

    @XmlTransient
    public List<Empresa> getEmpresaList1() {
        return empresaList1;
    }

    public void setEmpresaList1(List<Empresa> empresaList1) {
        this.empresaList1 = empresaList1;
    }

    @XmlTransient
    public List<Empresa> getEmpresaList2() {
        return empresaList2;
    }

    public void setEmpresaList2(List<Empresa> empresaList2) {
        this.empresaList2 = empresaList2;
    }

    @XmlTransient
    public List<Empresa> getEmpresaList3() {
        return empresaList3;
    }

    public void setEmpresaList3(List<Empresa> empresaList3) {
        this.empresaList3 = empresaList3;
    }

    @XmlTransient
    public List<FacturasCompra> getFacturasCompraList() {
        return facturasCompraList;
    }

    public void setFacturasCompraList(List<FacturasCompra> facturasCompraList) {
        this.facturasCompraList = facturasCompraList;
    }

    @XmlTransient
    public List<Inventario> getInventarioList() {
        return inventarioList;
    }

    public void setInventarioList(List<Inventario> inventarioList) {
        this.inventarioList = inventarioList;
    }

    @XmlTransient
    public List<Inventario> getInventarioList1() {
        return inventarioList1;
    }

    public void setInventarioList1(List<Inventario> inventarioList1) {
        this.inventarioList1 = inventarioList1;
    }

    @XmlTransient
    public List<Inventario> getInventarioList2() {
        return inventarioList2;
    }

    public void setInventarioList2(List<Inventario> inventarioList2) {
        this.inventarioList2 = inventarioList2;
    }

    @XmlTransient
    public List<Inventario> getInventarioList3() {
        return inventarioList3;
    }

    public void setInventarioList3(List<Inventario> inventarioList3) {
        this.inventarioList3 = inventarioList3;
    }

    @XmlTransient
    public List<Productos> getProductosList() {
        return productosList;
    }

    public void setProductosList(List<Productos> productosList) {
        this.productosList = productosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (batId != null ? batId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BasicaTipo)) {
            return false;
        }
        BasicaTipo other = (BasicaTipo) object;
        if ((this.batId == null && other.batId != null) || (this.batId != null && !this.batId.equals(other.batId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ventins.entities.BasicaTipo[ batId=" + batId + " ]";
    }
    
}
