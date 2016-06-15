
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
public class ListaProductos implements Serializable {    
    private ObservableList<Producto> lista;

    public static final String PROP_LISTA = "lista";
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    public ListaProductos() {
        lista = ObservableCollections.observableList(new ArrayList<Producto>());
    }
    
    public ObservableList<Producto> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Producto> lista) {
        ObservableList<Producto> oldLista = this.lista;
        this.lista = lista;
        propertyChangeSupport.firePropertyChange(PROP_LISTA, oldLista, lista);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    
    public boolean existeProducto(Producto p) {
        return lista.contains(p);
    }
    
    public void altaProducto(Producto p) {
        lista.add(p);
    }
    
    public void bajaProducto(Producto p) {
        lista.remove(p);
    }
    
    public ListaProductos productosEnStock() {
        ListaProductos productos = new ListaProductos();
        
        for (Producto p : lista) {
            if (p.getStock() > 0) productos.altaProducto(p);
        }
        
        return productos;
    }
}
