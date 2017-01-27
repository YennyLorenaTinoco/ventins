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
@Table(name = "usuarios", catalog = "ventins", schema = "ventins")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByUsuId", query = "SELECT u FROM Usuarios u WHERE u.usuId = :usuId")
    , @NamedQuery(name = "Usuarios.findByUsuNombre", query = "SELECT u FROM Usuarios u WHERE u.usuNombre = :usuNombre")
    , @NamedQuery(name = "Usuarios.findByUsuIden", query = "SELECT u FROM Usuarios u WHERE u.usuIden = :usuIden")
    , @NamedQuery(name = "Usuarios.findByUsuApellidos", query = "SELECT u FROM Usuarios u WHERE u.usuApellidos = :usuApellidos")
    , @NamedQuery(name = "Usuarios.findByUsuLogin", query = "SELECT u FROM Usuarios u WHERE u.usuLogin = :usuLogin")
    , @NamedQuery(name = "Usuarios.findByUsuPass", query = "SELECT u FROM Usuarios u WHERE u.usuPass = :usuPass")})
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
    @JoinColumn(name = "bat_tipo_doc", referencedColumnName = "bat_id")
    @ManyToOne(optional = false)
    private BasicaTipo batTipoDoc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuIdGas")
    private List<Gastos> gastosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuIdGen")
    private List<Gastos> gastosList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuId")
    private List<Ventas> ventasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuRegFacCompra")
    private List<FacturasCompra> facturasCompraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuCancFacCompra")
    private List<FacturasCompra> facturasCompraList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuId")
    private List<Cajas> cajasList;

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

    public BasicaTipo getBatTipoDoc() {
        return batTipoDoc;
    }

    public void setBatTipoDoc(BasicaTipo batTipoDoc) {
        this.batTipoDoc = batTipoDoc;
    }

    @XmlTransient
    public List<Gastos> getGastosList() {
        return gastosList;
    }

    public void setGastosList(List<Gastos> gastosList) {
        this.gastosList = gastosList;
    }

    @XmlTransient
    public List<Gastos> getGastosList1() {
        return gastosList1;
    }

    public void setGastosList1(List<Gastos> gastosList1) {
        this.gastosList1 = gastosList1;
    }

    @XmlTransient
    public List<Ventas> getVentasList() {
        return ventasList;
    }

    public void setVentasList(List<Ventas> ventasList) {
        this.ventasList = ventasList;
    }

    @XmlTransient
    public List<FacturasCompra> getFacturasCompraList() {
        return facturasCompraList;
    }

    public void setFacturasCompraList(List<FacturasCompra> facturasCompraList) {
        this.facturasCompraList = facturasCompraList;
    }

    @XmlTransient
    public List<FacturasCompra> getFacturasCompraList1() {
        return facturasCompraList1;
    }

    public void setFacturasCompraList1(List<FacturasCompra> facturasCompraList1) {
        this.facturasCompraList1 = facturasCompraList1;
    }

    @XmlTransient
    public List<Cajas> getCajasList() {
        return cajasList;
    }

    public void setCajasList(List<Cajas> cajasList) {
        this.cajasList = cajasList;
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
