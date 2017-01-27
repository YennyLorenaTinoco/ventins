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
@Table(name = "proveedores", catalog = "ventins", schema = "ventins")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedores.findAll", query = "SELECT p FROM Proveedores p")
    , @NamedQuery(name = "Proveedores.findByProvId", query = "SELECT p FROM Proveedores p WHERE p.provId = :provId")
    , @NamedQuery(name = "Proveedores.findByProvNombre", query = "SELECT p FROM Proveedores p WHERE p.provNombre = :provNombre")
    , @NamedQuery(name = "Proveedores.findByProvNit", query = "SELECT p FROM Proveedores p WHERE p.provNit = :provNit")
    , @NamedQuery(name = "Proveedores.findByProvDireccion", query = "SELECT p FROM Proveedores p WHERE p.provDireccion = :provDireccion")
    , @NamedQuery(name = "Proveedores.findByProvTelefono", query = "SELECT p FROM Proveedores p WHERE p.provTelefono = :provTelefono")})
public class Proveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prov_id")
    private Long provId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "prov_nombre")
    private String provNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "prov_nit")
    private String provNit;
    @Size(max = 255)
    @Column(name = "prov_direccion")
    private String provDireccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prov_telefono")
    private long provTelefono;
    @JoinColumn(name = "bat_pais", referencedColumnName = "bat_id")
    @ManyToOne
    private BasicaTipo batPais;
    @JoinColumn(name = "bat_mun", referencedColumnName = "bat_id")
    @ManyToOne
    private BasicaTipo batMun;
    @JoinColumn(name = "bat_depto", referencedColumnName = "bat_id")
    @ManyToOne
    private BasicaTipo batDepto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provId")
    private List<FacturasCompra> facturasCompraList;

    public Proveedores() {
    }

    public Proveedores(Long provId) {
        this.provId = provId;
    }

    public Proveedores(Long provId, String provNombre, String provNit, long provTelefono) {
        this.provId = provId;
        this.provNombre = provNombre;
        this.provNit = provNit;
        this.provTelefono = provTelefono;
    }

    public Long getProvId() {
        return provId;
    }

    public void setProvId(Long provId) {
        this.provId = provId;
    }

    public String getProvNombre() {
        return provNombre;
    }

    public void setProvNombre(String provNombre) {
        this.provNombre = provNombre;
    }

    public String getProvNit() {
        return provNit;
    }

    public void setProvNit(String provNit) {
        this.provNit = provNit;
    }

    public String getProvDireccion() {
        return provDireccion;
    }

    public void setProvDireccion(String provDireccion) {
        this.provDireccion = provDireccion;
    }

    public long getProvTelefono() {
        return provTelefono;
    }

    public void setProvTelefono(long provTelefono) {
        this.provTelefono = provTelefono;
    }

    public BasicaTipo getBatPais() {
        return batPais;
    }

    public void setBatPais(BasicaTipo batPais) {
        this.batPais = batPais;
    }

    public BasicaTipo getBatMun() {
        return batMun;
    }

    public void setBatMun(BasicaTipo batMun) {
        this.batMun = batMun;
    }

    public BasicaTipo getBatDepto() {
        return batDepto;
    }

    public void setBatDepto(BasicaTipo batDepto) {
        this.batDepto = batDepto;
    }

    @XmlTransient
    public List<FacturasCompra> getFacturasCompraList() {
        return facturasCompraList;
    }

    public void setFacturasCompraList(List<FacturasCompra> facturasCompraList) {
        this.facturasCompraList = facturasCompraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provId != null ? provId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedores)) {
            return false;
        }
        Proveedores other = (Proveedores) object;
        if ((this.provId == null && other.provId != null) || (this.provId != null && !this.provId.equals(other.provId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ventins.entities.Proveedores[ provId=" + provId + " ]";
    }
    
}
