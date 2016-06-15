/*
 * Clase Jugador (hereda de Persona)
 */
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mfontana
 */
public class Jugador extends Persona implements Cloneable, Serializable {    
    private String posicion;
    private boolean diestro;
    
    public static final String PROP_POSICION = "posicion";
    public static final String PROP_DIESTRO = "diestro";
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public Jugador() {
        super();
        posicion = "";
    }

    @Override
    public Object clone() {
        try { 
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        String oldPosicion = this.posicion;
        this.posicion = posicion;
        propertyChangeSupport.firePropertyChange(PROP_POSICION, oldPosicion, posicion);
    }

    public boolean isDiestro() {
        return diestro;
    }

    public void setDiestro(boolean diestro) {
        boolean oldDiestro = this.diestro;
        this.diestro = diestro;
        propertyChangeSupport.firePropertyChange(PROP_DIESTRO, oldDiestro, diestro);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        super.removePropertyChangeListener(listener);
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
