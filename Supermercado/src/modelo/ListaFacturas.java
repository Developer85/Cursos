
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
public class ListaFacturas implements Serializable {    
    private ObservableList<Factura> lista;

    public static final String PROP_LISTA = "lista";
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    public ListaFacturas() {
        lista = ObservableCollections.observableList(new ArrayList<Factura>());
    }

    public ObservableList<Factura> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Factura> lista) {
        ObservableList<Factura> oldLista = this.lista;
        this.lista = lista;
        propertyChangeSupport.firePropertyChange(PROP_LISTA, oldLista, lista);
    }    

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public boolean existeFactura(Factura f) {
        return lista.contains(f);
    }
    
    public void altaFactura(Factura f) {
        lista.add(f);
    }
}
