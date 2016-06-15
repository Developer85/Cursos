/*
 * Clase Entrenador, hereda de Persona
 */
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author mfontana
 */
public class Entrenador extends Persona {
    private String numLicencia;
    private int experiencia;
    
    public static final String PROP_NUMLICENCIA = "numLicencia";
    public static final String PROP_EXPERIENCIA = "experiencia";
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    public Entrenador() {
        super();
        numLicencia = "";
    }
    
    public String getNumLicencia() {
        return numLicencia;
    }
    
    public void setNumLicencia(String numLicencia) {
        String oldNumLicencia = this.numLicencia;
        this.numLicencia = numLicencia;
        propertyChangeSupport.firePropertyChange(PROP_NUMLICENCIA, oldNumLicencia, numLicencia);
    }
    
    public int getExperiencia() {
        return experiencia;
    }
    
    public void setExperiencia(int experiencia) {
        int oldExperiencia = this.experiencia;
        this.experiencia = experiencia;
        propertyChangeSupport.firePropertyChange(PROP_EXPERIENCIA, oldExperiencia, experiencia);
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
