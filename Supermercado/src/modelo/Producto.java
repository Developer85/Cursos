
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 *
 * @author usu21
 */
public class Producto implements Serializable, Comparable, Cloneable {    
    private int codigo;
    private String descripcion;
    private double pvp;
    private int stock;    

    public static final String PROP_CODIGO = "codigo";
    public static final String PROP_DESCRIPCION = "descripcion";
    public static final String PROP_PVP = "pvp";
    public static final String PROP_STOCK = "stock";
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    public Producto() {
        this(0, "", 0, 0);
//        descripcion = "";
    }

    public Producto(int codigo, String descripcion, double pvp, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.pvp = pvp;
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.codigo;
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
        final Producto other = (Producto) obj;
        return other.getCodigo() == codigo;
    }

    @Override
    public String toString() {
        if (descripcion.equals("-- Escoge un producto --"))
            return descripcion;
        else
            return descripcion + " - " + pvp + " €";
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        int oldCodigo = this.codigo;
        this.codigo = codigo;
        propertyChangeSupport.firePropertyChange(PROP_CODIGO, oldCodigo, codigo);
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        String oldDescripcion = this.descripcion;
        this.descripcion = descripcion;
        propertyChangeSupport.firePropertyChange(PROP_DESCRIPCION, oldDescripcion, descripcion);
    }
    
    public double getPvp() {
        return pvp;
    }

    public void setPvp(double pvp) {
        double oldPvp = this.pvp;
        this.pvp = pvp;
        propertyChangeSupport.firePropertyChange(PROP_PVP, oldPvp, pvp);
    }
    
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        int oldStock = this.stock;
        this.stock = stock;
        propertyChangeSupport.firePropertyChange(PROP_STOCK, oldStock, stock);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }    

    @Override
    public int compareTo(Object o) {
        Producto otro = (Producto) o;
        return descripcion.compareTo(otro.getDescripcion());
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println("Error!!! No se ha podido clonar el objeto.");
            return null;
        }
    }  
}
