/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventins.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v")
    , @NamedQuery(name = "Ventas.findByVentaId", query = "SELECT v FROM Ventas v WHERE v.ventaId = :ventaId")
    , @NamedQuery(name = "Ventas.findByVentaNumFact", query = "SELECT v FROM Ventas v WHERE v.ventaNumFact = :ventaNumFact")
    , @NamedQuery(name = "Ventas.findByVentaFecha", query = "SELECT v FROM Ventas v WHERE v.ventaFecha = :ventaFecha")
    , @NamedQuery(name = "Ventas.findByVentaVlorTotal", query = "SELECT v FROM Ventas v WHERE v.ventaVlorTotal = :ventaVlorTotal")
    , @NamedQuery(name = "Ventas.findByVentaDcto", query = "SELECT v FROM Ventas v WHERE v.ventaDcto = :ventaDcto")
    , @NamedQuery(name = "Ventas.findByVentaEfect", query = "SELECT v FROM Ventas v WHERE v.ventaEfect = :ventaEfect")
    , @NamedQuery(name = "Ventas.findByVentaEstado", query = "SELECT v FROM Ventas v WHERE v.ventaEstado = :ventaEstado")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "venta_id")
    private Long ventaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "venta_num_fact")
    private long ventaNumFact;
    @Basic(optional = false)
    @NotNull
    @Column(name = "venta_fecha")
    @Temporal(TemporalType.DATE)
    private Date ventaFecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "venta_vlor_total")
    private long ventaVlorTotal;
    @Column(name = "venta_dcto")
    private Long ventaDcto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "venta_efect")
    private long ventaEfect;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "venta_estado")
    private String ventaEstado;
    @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id")
    @ManyToOne
    private Clientes clienteId;
    @JoinColumn(name = "usu_id", referencedColumnName = "usu_id")
    @ManyToOne(optional = false)
    private Usuarios usuId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventaId")
    private Collection<VentaDetalle> ventaDetalleCollection;

    public Ventas() {
    }

    public Ventas(Long ventaId) {
        this.ventaId = ventaId;
    }

    public Ventas(Long ventaId, long ventaNumFact, Date ventaFecha, long ventaVlorTotal, long ventaEfect, String ventaEstado) {
        this.ventaId = ventaId;
        this.ventaNumFact = ventaNumFact;
        this.ventaFecha = ventaFecha;
        this.ventaVlorTotal = ventaVlorTotal;
        this.ventaEfect = ventaEfect;
        this.ventaEstado = ventaEstado;
    }

    public Long getVentaId() {
        return ventaId;
    }

    public void setVentaId(Long ventaId) {
        this.ventaId = ventaId;
    }

    public long getVentaNumFact() {
        return ventaNumFact;
    }

    public void setVentaNumFact(long ventaNumFact) {
        this.ventaNumFact = ventaNumFact;
    }

    public Date getVentaFecha() {
        return ventaFecha;
    }

    public void setVentaFecha(Date ventaFecha) {
        this.ventaFecha = ventaFecha;
    }

    public long getVentaVlorTotal() {
        return ventaVlorTotal;
    }

    public void setVentaVlorTotal(long ventaVlorTotal) {
        this.ventaVlorTotal = ventaVlorTotal;
    }

    public Long getVentaDcto() {
        return ventaDcto;
    }

    public void setVentaDcto(Long ventaDcto) {
        this.ventaDcto = ventaDcto;
    }

    public long getVentaEfect() {
        return ventaEfect;
    }

    public void setVentaEfect(long ventaEfect) {
        this.ventaEfect = ventaEfect;
    }

    public String getVentaEstado() {
        return ventaEstado;
    }

    public void setVentaEstado(String ventaEstado) {
        this.ventaEstado = ventaEstado;
    }

    public Clientes getClienteId() {
        return clienteId;
    }

    public void setClienteId(Clientes clienteId) {
        this.clienteId = clienteId;
    }

    public Usuarios getUsuId() {
        return usuId;
    }

    public void setUsuId(Usuarios usuId) {
        this.usuId = usuId;
    }

    @XmlTransient
    public Collection<VentaDetalle> getVentaDetalleCollection() {
        return ventaDetalleCollection;
    }

    public void setVentaDetalleCollection(Collection<VentaDetalle> ventaDetalleCollection) {
        this.ventaDetalleCollection = ventaDetalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventaId != null ? ventaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.ventaId == null && other.ventaId != null) || (this.ventaId != null && !this.ventaId.equals(other.ventaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ventins.entities.Ventas[ ventaId=" + ventaId + " ]";
    }
    
}
