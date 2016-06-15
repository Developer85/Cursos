
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author usu21
 */
public class ListaPeliculas {    
    private ObservableList<Pelicula> lista;

    public static final String PROP_LISTA = "lista";
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public ListaPeliculas() {
        lista = ObservableCollections.observableList(new ArrayList<Pelicula>());
    }
    
    public ObservableList<Pelicula> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Pelicula> lista) {
        ObservableList<Pelicula> oldLista = this.lista;
        this.lista = lista;
        propertyChangeSupport.firePropertyChange(PROP_LISTA, oldLista, lista);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    
    public void altaPelicula(Pelicula p) {
        lista.add(p);
    }
    
    public void bajaPelicula(Pelicula p) {
        lista.remove(p);
    }

}
