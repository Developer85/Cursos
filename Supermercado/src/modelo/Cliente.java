
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author usu21
 */
public class Cliente implements Serializable, Comparable, Cloneable {    
    private String nif;    
    private String nombre;    
    private String apellidos;    
    private String direccion;    
    private String poblacion;
    
    public static final String PROP_NIF = "nif";
    public static final String PROP_NOMBRE = "nombre";
    public static final String PROP_APELLIDOS = "apellidos";
    public static final String PROP_DIRECCION = "direccion";
    public static final String PROP_POBLACION = "poblacion";
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public Cliente() {
        this("", "", "", "", "");
//        nif = nombre = apellidos = direccion = poblacion = "";
    }

    public Cliente(String nif, String nombre, String apellidos, String direccion, String poblacion) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.poblacion = poblacion;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nif);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        return other.getNif().equalsIgnoreCase(nif);
    }

    @Override
    public String toString() {
        if (apellidos.equals("-- Escoge un cliente --"))
            return apellidos;
        else
            return apellidos + ", " + nombre;
    }
    
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        String oldNif = this.nif;
        this.nif = nif;
        propertyChangeSupport.firePropertyChange(PROP_NIF, oldNif, nif);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        propertyChangeSupport.firePropertyChange(PROP_NOMBRE, oldNombre, nombre);
    }
    
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        String oldApellidos = this.apellidos;
        this.apellidos = apellidos;
        propertyChangeSupport.firePropertyChange(PROP_APELLIDOS, oldApellidos, apellidos);
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        String oldDireccion = this.direccion;
        this.direccion = direccion;
        propertyChangeSupport.firePropertyChange(PROP_DIRECCION, oldDireccion, direccion);
    }
    
    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        String oldPoblacion = this.poblacion;
        this.poblacion = poblacion;
        propertyChangeSupport.firePropertyChange(PROP_POBLACION, oldPoblacion, poblacion);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    @Override
    public int compareTo(Object o) {
        Cliente otro = (Cliente) o;
        return apellidos.compareTo(otro.getApellidos());
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println("Error!!! No se ha podido clonar el objeto.");
            return null;
        }
    }
}
