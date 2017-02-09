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
@Table(name = "basica_tabla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BasicaTabla.findAll", query = "SELECT b FROM BasicaTabla b")
    , @NamedQuery(name = "BasicaTabla.findByBtlId", query = "SELECT b FROM BasicaTabla b WHERE b.btlId = :btlId")
    , @NamedQuery(name = "BasicaTabla.findByBtlNombre", query = "SELECT b FROM BasicaTabla b WHERE b.btlNombre = :btlNombre")
    , @NamedQuery(name = "BasicaTabla.findByBtlDescriptor", query = "SELECT b FROM BasicaTabla b WHERE b.btlDescriptor = :btlDescriptor")})
public class BasicaTabla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "btl_id")
    private Long btlId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "btl_nombre")
    private String btlNombre;
    @Size(max = 255)
    @Column(name = "btl_descriptor")
    private String btlDescriptor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "btlId")
    private Collection<BasicaTipo> basicaTipoCollection;

    public BasicaTabla() {
    }

    public BasicaTabla(Long btlId) {
        this.btlId = btlId;
    }

    public BasicaTabla(Long btlId, String btlNombre) {
        this.btlId = btlId;
        this.btlNombre = btlNombre;
    }

    public Long getBtlId() {
        return btlId;
    }

    public void setBtlId(Long btlId) {
        this.btlId = btlId;
    }

    public String getBtlNombre() {
        return btlNombre;
    }

    public void setBtlNombre(String btlNombre) {
        this.btlNombre = btlNombre;
    }

    public String getBtlDescriptor() {
        return btlDescriptor;
    }

    public void setBtlDescriptor(String btlDescriptor) {
        this.btlDescriptor = btlDescriptor;
    }

    @XmlTransient
    public Collection<BasicaTipo> getBasicaTipoCollection() {
        return basicaTipoCollection;
    }

    public void setBasicaTipoCollection(Collection<BasicaTipo> basicaTipoCollection) {
        this.basicaTipoCollection = basicaTipoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (btlId != null ? btlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BasicaTabla)) {
            return false;
        }
        BasicaTabla other = (BasicaTabla) object;
        if ((this.btlId == null && other.btlId != null) || (this.btlId != null && !this.btlId.equals(other.btlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ventins.entities.BasicaTabla[ btlId=" + btlId + " ]";
    }
    
}
