/*
 * Clase que encapsula la lista de entrenadores
 */
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author mfontana
 */
public class ListaEntrenadores implements Serializable {    
    private ObservableList<Entrenador> lista;
    
    public static final String PROP_LISTA = "lista";
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public ListaEntrenadores() {
        lista = ObservableCollections.observableList(new ArrayList<Entrenador>());
    }
    
    public ObservableList<Entrenador> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Entrenador> lista) {
        ObservableList<Entrenador> oldLista = this.lista;
        this.lista = lista;
        propertyChangeSupport.firePropertyChange(PROP_LISTA, oldLista, lista);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public void altaEntrenador(Entrenador e) {
        lista.add(e);
    }
    
    public void bajaEntrenador(Entrenador e) {
        lista.remove(e);
    }
    
    public boolean existeEntrenador(Entrenador e) {
        return lista.contains(e);
    }

    public ListaEntrenadores copia() {
        ListaEntrenadores copia = new ListaEntrenadores();
        for (Entrenador e : lista) {
            copia.altaEntrenador(e);
        }
        return copia;
    }
    
    public ListaEntrenadores entrenadoresLibres(ListaEntrenadores ocupados) {
        ListaEntrenadores libres = new ListaEntrenadores();
        
        for (Entrenador e : lista) {
            if (!ocupados.existeEntrenador(e)) {
                libres.altaEntrenador(e);
            }
        }
        
        return libres;
    }
}
