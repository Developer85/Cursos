
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 *
 * @author usu21
 */
public class ListaPrendas implements Serializable {
    private ArrayList<Prenda> lista;

    public ListaPrendas() {
        lista = new ArrayList<>();
    }

    public ArrayList<Prenda> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Prenda> lista) {
        this.lista = lista;
    }
    
    public void altaPrenda(Prenda p) {
        lista.add(p);
    }
    
    public int cantidadPrendas() {
        return lista.size();
    }
    
    public boolean existePrenda(Prenda p) {
        return lista.contains(p);
    }
    
    public ArrayList<String> listadoColores() {
        ArrayList<String> tempColores = new ArrayList<>();
        
        for (Prenda p : lista)
            tempColores.add(p.getColor());
                
        ArrayList<String> colores = new ArrayList<>(new HashSet<>(tempColores));
        Collections.sort(colores);
        
        return colores;
    }
    
    public ListaPrendas prendasPorColor(String color) {        
        ListaPrendas prendasPorColor = new ListaPrendas();
        
        for (Prenda p : lista)
            if (p.getColor().equalsIgnoreCase(color)) prendasPorColor.altaPrenda(p);
                
        return prendasPorColor;
    }
    
    /*
    public int indicePrenda(Prenda p) {
        return lista.indexOf(p);
    }
    
    public void actualizarPrenda(int indice, Prenda p) {
        lista.set(indice, p);
    }
    */
    
    public int cantidadStock() {
        int cantidad = 0;
        
        for (Prenda p : lista)
            cantidad += p.getStock();
        
        return cantidad;
    }
    
    public double valoracionStock() {
        double valoracion = 0;
        
        for (Prenda p : lista)
            valoracion += p.getPrecioCoste() * p.getStock();
        
        return valoracion;
    }
}
