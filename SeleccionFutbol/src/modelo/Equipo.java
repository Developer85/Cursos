
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author mfontana
 */
public class Equipo implements Serializable {    
    private String nombre;
    private String pais;
    private Entrenador entrenador;
    private ListaJugadores jugadores;

    public static final String PROP_NOMBRE = "nombre";
    public static final String PROP_PAIS = "pais";
    public static final String PROP_ENTRENADOR = "entrenador";
    public static final String PROP_JUGADORES = "jugadores";
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    public Equipo() {
        nombre = "";
        pais = "";
        entrenador = new Entrenador();
        jugadores = new ListaJugadores();
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.nombre);
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
        final Equipo other = (Equipo) obj;
        return this.nombre.equalsIgnoreCase(other.getNombre());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        propertyChangeSupport.firePropertyChange(PROP_NOMBRE, oldNombre, nombre);
    }
    
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        String oldPais = this.pais;
        this.pais = pais;
        propertyChangeSupport.firePropertyChange(PROP_PAIS, oldPais, pais);
    }
    
    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        Entrenador oldEntrenador = this.entrenador;
        this.entrenador = entrenador;
        propertyChangeSupport.firePropertyChange(PROP_ENTRENADOR, oldEntrenador, entrenador);
    }
    
    public ListaJugadores getJugadores() {
        return jugadores;
    }

    public void setJugadores(ListaJugadores jugadores) {
        ListaJugadores oldJugadores = this.jugadores;
        this.jugadores = jugadores;
        propertyChangeSupport.firePropertyChange(PROP_JUGADORES, oldJugadores, jugadores);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
