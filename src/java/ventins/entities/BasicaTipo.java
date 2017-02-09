/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventins.entities;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "basica_tipo")
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
    private Collection<Usuarios> usuariosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batConcGasto")
    private Collection<Gastos> gastosCollection;
    @OneToMany(mappedBy = "batPais")
    private Collection<Proveedores> proveedoresCollection;
    @OneToMany(mappedBy = "batMun")
    private Collection<Proveedores> proveedoresCollection1;
    @OneToMany(mappedBy = "batDepto")
    private Collection<Proveedores> proveedoresCollection2;
    @JoinColumn(name = "btl_id", referencedColumnName = "btl_id")
    @ManyToOne(optional = false)
    private BasicaTabla btlId;
    @OneToMany(mappedBy = "batTipoDoc")
    private Collection<Clientes> clientesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batPais")
    private Collection<Empresa> empresaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batDepto")
    private Collection<Empresa> empresaCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batMun")
    private Collection<Empresa> empresaCollection2;
    @OneToMany(mappedBy = "batBarrio")
    private Collection<Empresa> empresaCollection3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batConcCompra")
    private Collection<FacturasCompra> facturasCompraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batGrupo")
    private Collection<Inventario> inventarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batNivel")
    private Collection<Inventario> inventarioCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batEstante")
    private Collection<Inventario> inventarioCollection2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batUni")
    private Collection<Inventario> inventarioCollection3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prodCodigo")
    private Collection<Productos> productosCollection;

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
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    @XmlTransient
    public Collection<Gastos> getGastosCollection() {
        return gastosCollection;
    }

    public void setGastosCollection(Collection<Gastos> gastosCollection) {
        this.gastosCollection = gastosCollection;
    }

    @XmlTransient
    public Collection<Proveedores> getProveedoresCollection() {
        return proveedoresCollection;
    }

    public void setProveedoresCollection(Collection<Proveedores> proveedoresCollection) {
        this.proveedoresCollection = proveedoresCollection;
    }

    @XmlTransient
    public Collection<Proveedores> getProveedoresCollection1() {
        return proveedoresCollection1;
    }

    public void setProveedoresCollection1(Collection<Proveedores> proveedoresCollection1) {
        this.proveedoresCollection1 = proveedoresCollection1;
    }

    @XmlTransient
    public Collection<Proveedores> getProveedoresCollection2() {
        return proveedoresCollection2;
    }

    public void setProveedoresCollection2(Collection<Proveedores> proveedoresCollection2) {
        this.proveedoresCollection2 = proveedoresCollection2;
    }

    public BasicaTabla getBtlId() {
        return btlId;
    }

    public void setBtlId(BasicaTabla btlId) {
        this.btlId = btlId;
    }

    @XmlTransient
    public Collection<Clientes> getClientesCollection() {
        return clientesCollection;
    }

    public void setClientesCollection(Collection<Clientes> clientesCollection) {
        this.clientesCollection = clientesCollection;
    }

    @XmlTransient
    public Collection<Empresa> getEmpresaCollection() {
        return empresaCollection;
    }

    public void setEmpresaCollection(Collection<Empresa> empresaCollection) {
        this.empresaCollection = empresaCollection;
    }

    @XmlTransient
    public Collection<Empresa> getEmpresaCollection1() {
        return empresaCollection1;
    }

    public void setEmpresaCollection1(Collection<Empresa> empresaCollection1) {
        this.empresaCollection1 = empresaCollection1;
    }

    @XmlTransient
    public Collection<Empresa> getEmpresaCollection2() {
        return empresaCollection2;
    }

    public void setEmpresaCollection2(Collection<Empresa> empresaCollection2) {
        this.empresaCollection2 = empresaCollection2;
    }

    @XmlTransient
    public Collection<Empresa> getEmpresaCollection3() {
        return empresaCollection3;
    }

    public void setEmpresaCollection3(Collection<Empresa> empresaCollection3) {
        this.empresaCollection3 = empresaCollection3;
    }

    @XmlTransient
    public Collection<FacturasCompra> getFacturasCompraCollection() {
        return facturasCompraCollection;
    }

    public void setFacturasCompraCollection(Collection<FacturasCompra> facturasCompraCollection) {
        this.facturasCompraCollection = facturasCompraCollection;
    }

    @XmlTransient
    public Collection<Inventario> getInventarioCollection() {
        return inventarioCollection;
    }

    public void setInventarioCollection(Collection<Inventario> inventarioCollection) {
        this.inventarioCollection = inventarioCollection;
    }

    @XmlTransient
    public Collection<Inventario> getInventarioCollection1() {
        return inventarioCollection1;
    }

    public void setInventarioCollection1(Collection<Inventario> inventarioCollection1) {
        this.inventarioCollection1 = inventarioCollection1;
    }

    @XmlTransient
    public Collection<Inventario> getInventarioCollection2() {
        return inventarioCollection2;
    }

    public void setInventarioCollection2(Collection<Inventario> inventarioCollection2) {
        this.inventarioCollection2 = inventarioCollection2;
    }

    @XmlTransient
    public Collection<Inventario> getInventarioCollection3() {
        return inventarioCollection3;
    }

    public void setInventarioCollection3(Collection<Inventario> inventarioCollection3) {
        this.inventarioCollection3 = inventarioCollection3;
    }

    @XmlTransient
    public Collection<Productos> getProductosCollection() {
        return productosCollection;
    }

    public void setProductosCollection(Collection<Productos> productosCollection) {
        this.productosCollection = productosCollection;
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
