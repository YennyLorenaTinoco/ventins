/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventins.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c")
    , @NamedQuery(name = "Clientes.findByClienteId", query = "SELECT c FROM Clientes c WHERE c.clienteId = :clienteId")
    , @NamedQuery(name = "Clientes.findByClienteNombre", query = "SELECT c FROM Clientes c WHERE c.clienteNombre = :clienteNombre")
    , @NamedQuery(name = "Clientes.findByClienteApellido", query = "SELECT c FROM Clientes c WHERE c.clienteApellido = :clienteApellido")
    , @NamedQuery(name = "Clientes.findByClienteNumIden", query = "SELECT c FROM Clientes c WHERE c.clienteNumIden = :clienteNumIden")
    , @NamedQuery(name = "Clientes.findByClienteDireccion", query = "SELECT c FROM Clientes c WHERE c.clienteDireccion = :clienteDireccion")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cliente_id")
    private Long clienteId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cliente_nombre")
    private String clienteNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cliente_apellido")
    private String clienteApellido;
    @Column(name = "cliente_num_iden")
    private Long clienteNumIden;
    @Size(max = 255)
    @Column(name = "cliente_direccion")
    private String clienteDireccion;
    @OneToMany(mappedBy = "clienteId")
    private Collection<Ventas> ventasCollection;
    @JoinColumn(name = "bat_tipo_doc", referencedColumnName = "bat_id")
    @ManyToOne
    private BasicaTipo batTipoDoc;

    public Clientes() {
    }

    public Clientes(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Clientes(Long clienteId, String clienteNombre, String clienteApellido) {
        this.clienteId = clienteId;
        this.clienteNombre = clienteNombre;
        this.clienteApellido = clienteApellido;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getClienteApellido() {
        return clienteApellido;
    }

    public void setClienteApellido(String clienteApellido) {
        this.clienteApellido = clienteApellido;
    }

    public Long getClienteNumIden() {
        return clienteNumIden;
    }

    public void setClienteNumIden(Long clienteNumIden) {
        this.clienteNumIden = clienteNumIden;
    }

    public String getClienteDireccion() {
        return clienteDireccion;
    }

    public void setClienteDireccion(String clienteDireccion) {
        this.clienteDireccion = clienteDireccion;
    }

    @XmlTransient
    public Collection<Ventas> getVentasCollection() {
        return ventasCollection;
    }

    public void setVentasCollection(Collection<Ventas> ventasCollection) {
        this.ventasCollection = ventasCollection;
    }

    public BasicaTipo getBatTipoDoc() {
        return batTipoDoc;
    }

    public void setBatTipoDoc(BasicaTipo batTipoDoc) {
        this.batTipoDoc = batTipoDoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteId != null ? clienteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.clienteId == null && other.clienteId != null) || (this.clienteId != null && !this.clienteId.equals(other.clienteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ventins.entities.Clientes[ clienteId=" + clienteId + " ]";
    }
    
}
