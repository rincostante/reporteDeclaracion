

package ar.gob.ambiente.aplicaciones.reportedeclaracion.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase que encapsula los datos correspondientes al parámetro Tipo de la forma de abastecimiento de agua
 * por el Establecimiento para hacer sus Descargas.
 * @author carmendariz
 */
@Entity
public class TipoAbasto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Campo que guarda la denominación del Tipo de Abasto
     */
    @Column (nullable=false, length=100, unique=false)
    @NotNull(message = "El campo nombre no puede ser nulo")
    @Size(message = "El campo nombre no puede tener más de 100 caracteres", min = 1, max = 100)
    private String nombre;   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        if (!(object instanceof TipoAbasto)) {
            return false;
        }
        TipoAbasto other = (TipoAbasto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.gob.ambiente.aplicaciones.reportedeclaracion.modelo.TipoAbasto[ id=" + id + " ]";
    }
    
}