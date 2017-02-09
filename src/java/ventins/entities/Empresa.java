/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventins.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lorena
 */
@Entity
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")
    , @NamedQuery(name = "Empresa.findByEmpId", query = "SELECT e FROM Empresa e WHERE e.empId = :empId")
    , @NamedQuery(name = "Empresa.findByEmpNombre", query = "SELECT e FROM Empresa e WHERE e.empNombre = :empNombre")
    , @NamedQuery(name = "Empresa.findByEmpDireccion", query = "SELECT e FROM Empresa e WHERE e.empDireccion = :empDireccion")
    , @NamedQuery(name = "Empresa.findByEmpresaNit", query = "SELECT e FROM Empresa e WHERE e.empresaNit = :empresaNit")
    , @NamedQuery(name = "Empresa.findByEmpTelefono", query = "SELECT e FROM Empresa e WHERE e.empTelefono = :empTelefono")
    , @NamedQuery(name = "Empresa.findByEmpresaRegimen", query = "SELECT e FROM Empresa e WHERE e.empresaRegimen = :empresaRegimen")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "emp_id")
    private Long empId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "emp_nombre")
    private String empNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "emp_direccion")
    private String empDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "empresa_nit")
    private String empresaNit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "emp_telefono")
    private long empTelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "empresa_regimen")
    private String empresaRegimen;
    @JoinColumn(name = "bat_pais", referencedColumnName = "bat_id")
    @ManyToOne(optional = false)
    private BasicaTipo batPais;
    @JoinColumn(name = "bat_depto", referencedColumnName = "bat_id")
    @ManyToOne(optional = false)
    private BasicaTipo batDepto;
    @JoinColumn(name = "bat_mun", referencedColumnName = "bat_id")
    @ManyToOne(optional = false)
    private BasicaTipo batMun;
    @JoinColumn(name = "bat_barrio", referencedColumnName = "bat_id")
    @ManyToOne
    private BasicaTipo batBarrio;

    public Empresa() {
    }

    public Empresa(Long empId) {
        this.empId = empId;
    }

    public Empresa(Long empId, String empNombre, String empDireccion, String empresaNit, long empTelefono, String empresaRegimen) {
        this.empId = empId;
        this.empNombre = empNombre;
        this.empDireccion = empDireccion;
        this.empresaNit = empresaNit;
        this.empTelefono = empTelefono;
        this.empresaRegimen = empresaRegimen;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpNombre() {
        return empNombre;
    }

    public void setEmpNombre(String empNombre) {
        this.empNombre = empNombre;
    }

    public String getEmpDireccion() {
        return empDireccion;
    }

    public void setEmpDireccion(String empDireccion) {
        this.empDireccion = empDireccion;
    }

    public String getEmpresaNit() {
        return empresaNit;
    }

    public void setEmpresaNit(String empresaNit) {
        this.empresaNit = empresaNit;
    }

    public long getEmpTelefono() {
        return empTelefono;
    }

    public void setEmpTelefono(long empTelefono) {
        this.empTelefono = empTelefono;
    }

    public String getEmpresaRegimen() {
        return empresaRegimen;
    }

    public void setEmpresaRegimen(String empresaRegimen) {
        this.empresaRegimen = empresaRegimen;
    }

    public BasicaTipo getBatPais() {
        return batPais;
    }

    public void setBatPais(BasicaTipo batPais) {
        this.batPais = batPais;
    }

    public BasicaTipo getBatDepto() {
        return batDepto;
    }

    public void setBatDepto(BasicaTipo batDepto) {
        this.batDepto = batDepto;
    }

    public BasicaTipo getBatMun() {
        return batMun;
    }

    public void setBatMun(BasicaTipo batMun) {
        this.batMun = batMun;
    }

    public BasicaTipo getBatBarrio() {
        return batBarrio;
    }

    public void setBatBarrio(BasicaTipo batBarrio) {
        this.batBarrio = batBarrio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ventins.entities.Empresa[ empId=" + empId + " ]";
    }
    
}
