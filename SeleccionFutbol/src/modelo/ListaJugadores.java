/*
 * Clase para encapsular el ArrayList de Jugador
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
public class ListaJugadores implements Serializable {
    private ObservableList<Jugador> lista;
    
    public static final String PROP_LISTA = "lista";
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public ListaJugadores() {
        lista = ObservableCollections.observableList(new ArrayList<Jugador>());
    }
    
    public ObservableList<Jugador> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Jugador> lista) {
        ObservableList<Jugador> oldLista = this.lista;
        this.lista = lista;
        propertyChangeSupport.firePropertyChange(PROP_LISTA, oldLista, lista);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public void altaJugador(Jugador j) {
        lista.add(j);
    }
    
    public void bajaJugador(Jugador j) {
        lista.remove(j);
    }
    
    public boolean existeJugador(Jugador j) {
        return lista.contains(j);
    }
    
    public ListaJugadores jugadoresPorNacionalidad(String nacionalidad) {
        ListaJugadores result = new ListaJugadores();
        for (Jugador j : lista) {
            if (j.getNacionalidad().equals(nacionalidad)) {
                result.altaJugador(j);
            }
        }
        return result;
    }
    
    public ListaJugadores jugadoresLibres(ListaJugadores ocupados) {
        ListaJugadores libres = new ListaJugadores();
        
        for (Jugador j : lista) {
            if (!ocupados.existeJugador(j)) {
                libres.altaJugador(j);
            }
        }
        
        return libres;
    }
    
    public ListaJugadores jugadoresFiltrados(String patron) {
        ListaJugadores filtrados = new ListaJugadores();
        
        for (Jugador j : lista) {
            if (j.getNombre().contains(patron)) {
                filtrados.altaJugador(j);
            }
        }
        
        return filtrados;
    }
    
    public ListaJugadores copia() {
        ListaJugadores copia = new ListaJugadores();
        
        for (Jugador j : lista) {
            copia.altaJugador(j);
        }
        
        return copia;
    }
}
