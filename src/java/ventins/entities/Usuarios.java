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
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByUsuId", query = "SELECT u FROM Usuarios u WHERE u.usuId = :usuId")
    , @NamedQuery(name = "Usuarios.findByUsuNombre", query = "SELECT u FROM Usuarios u WHERE u.usuNombre = :usuNombre")
    , @NamedQuery(name = "Usuarios.findByUsuIden", query = "SELECT u FROM Usuarios u WHERE u.usuIden = :usuIden")
    , @NamedQuery(name = "Usuarios.findByUsuApellidos", query = "SELECT u FROM Usuarios u WHERE u.usuApellidos = :usuApellidos")
    , @NamedQuery(name = "Usuarios.findByUsuLogin", query = "SELECT u FROM Usuarios u WHERE u.usuLogin = :usuLogin")
    , @NamedQuery(name = "Usuarios.findByUsuPass", query = "SELECT u FROM Usuarios u WHERE u.usuPass = :usuPass")
    , @NamedQuery(name = "Usuarios.findByUsuEstado", query = "SELECT u FROM Usuarios u WHERE u.usuEstado = :usuEstado")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "usu_id")
    private Long usuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "usu_nombre")
    private String usuNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usu_iden")
    private long usuIden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "usu_apellidos")
    private String usuApellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "usu_login")
    private String usuLogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "usu_pass")
    private String usuPass;
    @Size(max = 2)
    @Column(name = "usu_estado")
    private String usuEstado;
    @JoinColumn(name = "per_id", referencedColumnName = "per_id")
    @ManyToOne
    private BPerfiles perId;
    @JoinColumn(name = "bat_tipo_doc", referencedColumnName = "bat_id")
    @ManyToOne(optional = false)
    private BasicaTipo batTipoDoc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuIdGas")
    private Collection<Gastos> gastosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuIdGen")
    private Collection<Gastos> gastosCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuId")
    private Collection<Ventas> ventasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuRegFacCompra")
    private Collection<FacturasCompra> facturasCompraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuCancFacCompra")
    private Collection<FacturasCompra> facturasCompraCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuId")
    private Collection<Cajas> cajasCollection;

    public Usuarios() {
    }

    public Usuarios(Long usuId) {
        this.usuId = usuId;
    }

    public Usuarios(Long usuId, String usuNombre, long usuIden, String usuApellidos, String usuLogin, String usuPass) {
        this.usuId = usuId;
        this.usuNombre = usuNombre;
        this.usuIden = usuIden;
        this.usuApellidos = usuApellidos;
        this.usuLogin = usuLogin;
        this.usuPass = usuPass;
    }

    public Long getUsuId() {
        return usuId;
    }

    public void setUsuId(Long usuId) {
        this.usuId = usuId;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public long getUsuIden() {
        return usuIden;
    }

    public void setUsuIden(long usuIden) {
        this.usuIden = usuIden;
    }

    public String getUsuApellidos() {
        return usuApellidos;
    }

    public void setUsuApellidos(String usuApellidos) {
        this.usuApellidos = usuApellidos;
    }

    public String getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public String getUsuPass() {
        return usuPass;
    }

    public void setUsuPass(String usuPass) {
        this.usuPass = usuPass;
    }

    public String getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(String usuEstado) {
        this.usuEstado = usuEstado;
    }

    public BPerfiles getPerId() {
        return perId;
    }

    public void setPerId(BPerfiles perId) {
        this.perId = perId;
    }

    public BasicaTipo getBatTipoDoc() {
        return batTipoDoc;
    }

    public void setBatTipoDoc(BasicaTipo batTipoDoc) {
        this.batTipoDoc = batTipoDoc;
    }

    @XmlTransient
    public Collection<Gastos> getGastosCollection() {
        return gastosCollection;
    }

    public void setGastosCollection(Collection<Gastos> gastosCollection) {
        this.gastosCollection = gastosCollection;
    }

    @XmlTransient
    public Collection<Gastos> getGastosCollection1() {
        return gastosCollection1;
    }

    public void setGastosCollection1(Collection<Gastos> gastosCollection1) {
        this.gastosCollection1 = gastosCollection1;
    }

    @XmlTransient
    public Collection<Ventas> getVentasCollection() {
        return ventasCollection;
    }

    public void setVentasCollection(Collection<Ventas> ventasCollection) {
        this.ventasCollection = ventasCollection;
    }

    @XmlTransient
    public Collection<FacturasCompra> getFacturasCompraCollection() {
        return facturasCompraCollection;
    }

    public void setFacturasCompraCollection(Collection<FacturasCompra> facturasCompraCollection) {
        this.facturasCompraCollection = facturasCompraCollection;
    }

    @XmlTransient
    public Collection<FacturasCompra> getFacturasCompraCollection1() {
        return facturasCompraCollection1;
    }

    public void setFacturasCompraCollection1(Collection<FacturasCompra> facturasCompraCollection1) {
        this.facturasCompraCollection1 = facturasCompraCollection1;
    }

    @XmlTransient
    public Collection<Cajas> getCajasCollection() {
        return cajasCollection;
    }

    public void setCajasCollection(Collection<Cajas> cajasCollection) {
        this.cajasCollection = cajasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ventins.entities.Usuarios[ usuId=" + usuId + " ]";
    }
    
}
