
package boutique;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author usu21
 */
public class Prenda implements Serializable {
    private String codigo;
    private String descripcion;
    private String talla;
    private String color;
    private double precioCoste;
    private double precioVenta;
    private int stock;

    public Prenda() {
        codigo = descripcion = talla = color = "";
        precioCoste = precioVenta = stock = 0;
    }

    public Prenda(String codigo, String descripcion, String talla, String color, double precioCoste, double precioVenta, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.talla = talla;
        this.color = color;
        this.precioCoste = precioCoste;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }
    
    @Override
    public String toString() {
        return codigo + " - " + descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        final Prenda other = (Prenda) obj;
        return Objects.equals(this.codigo, other.codigo);
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }    

    public double getPrecioCoste() {
        return precioCoste;
    }

    public void setPrecioCoste(double precioCoste) {
        this.precioCoste = precioCoste;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
