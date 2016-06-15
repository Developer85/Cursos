
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
public class ListaEquipos implements Serializable {    
    private ObservableList<Equipo> lista;

    public static final String PROP_LISTA = "lista";
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    public ListaEquipos() {
        lista = ObservableCollections.observableList(new ArrayList<Equipo>());
    }
    
    public ObservableList<Equipo> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Equipo> lista) {
        ObservableList<Equipo> oldLista = this.lista;
        this.lista = lista;
        propertyChangeSupport.firePropertyChange(PROP_LISTA, oldLista, lista);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    
    public void altaEquipo(Equipo e) {
        lista.add(e);
    }
    
    public void bajaEquipo(Equipo e) {
        lista.remove(e);
    }
    
    public boolean existeEquipo(Equipo e) {
        return lista.contains(e);
    }
    
    public ListaEntrenadores entrenadoresOcupados() {
        ListaEntrenadores ocupados = new ListaEntrenadores();
        
        for (Equipo e : lista) {
            ocupados.altaEntrenador(e.getEntrenador());
        }
        
        return ocupados;
    }
    
    public ListaJugadores jugadoresOcupados() {
        ListaJugadores ocupados = new ListaJugadores();
        
        for (Equipo e : lista) {
            for (Jugador j : e.getJugadores().getLista())
                ocupados.altaJugador(j);
        }
        
        return ocupados;
    }
}
