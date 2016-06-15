
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author usu21
 */
public class ListaPersonas implements Serializable {    
    private ObservableList<Persona> lista;

    public static final String PROP_LISTA = "lista";
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public ListaPersonas() {
        lista = ObservableCollections.observableList(new ArrayList<Persona>());
    }
    
    public ObservableList<Persona> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Persona> lista) {
        ObservableList<Persona> oldLista = this.lista;
        this.lista = lista;
        propertyChangeSupport.firePropertyChange(PROP_LISTA, oldLista, lista);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    
    public void altaPersona(Persona p) {
        lista.add(p);
    }
    
    public void bajaPersona(Persona p) {
        lista.remove(p);
    }
}
