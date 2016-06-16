
package ar.gob.ambiente.aplicaciones.reportedeclaracion.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entidad que encapsula la información de la persona que firma la declaración jurada en representación del establecimiento
 * @author rincostante
 */
@XmlRootElement(name = "firmante")
@Entity
@Table(name = "firmante")
public class Firmante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Guarda la referencia correspondiente a la persona física en el RUP
     * (para los firmantes no validados, que se ingresen al momento de firmar,
     * no se guardará)
     */
    private Long idRupFis;
 
    /**
     * Guarda el nombre y apellido obtenido de la persona del RUP
     */
    @Column (nullable=false, unique=true)
    @NotNull(message = "El campo nombreYApellido no puede ser nulo")
    private String nombreYApellido;
    
    /**
     * Guarda el cuti/cuil de la persona obtenida del RUP (para los firmantes no validados, que se ingresen al momento de firmar,
     * solo se guardará el dni)
     */
    private long cuit;
    
    /**
     * Guarda el dni para los casos en que la persona no sea validada en el RUP
     */
    private long dni;
    
    /**
     * Guarda una letra (M o F) si correspondiera
     */
    private String dniLetra;
   
    /**
     * Muestra las Declaraciones Juradas vinculadas al Firmante
     */
    @OneToMany (mappedBy="firmante")
    private List<DeclaracionJurada> declaraciones;      
    
    
    public Firmante(){
        declaraciones = new ArrayList<>();
    }

    public String getDniLetra() {
        return dniLetra;
    }

    public void setDniLetra(String dniLetra) {
        this.dniLetra = dniLetra;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getNombreYApellido() {
        return nombreYApellido;
    }

    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<DeclaracionJurada> getDeclaraciones() {
        return declaraciones;
    }

    public void setDeclaraciones(List<DeclaracionJurada> declaraciones) {
        this.declaraciones = declaraciones;
    }
    
    public Long getIdRupFis() {
        return idRupFis;
    }

    public void setIdRupFis(Long idRupFis) {
        this.idRupFis = idRupFis;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Firmante)) {
            return false;
        }
        Firmante other = (Firmante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.gob.ambiente.aplicaciones.reportedeclaracion.modelo.Firmante[ id=" + id + " ]";
    }
    
}