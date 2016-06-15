
package bancocastor;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author usu21
 */
public class ListaCuentas implements Serializable
{
    private ArrayList<Cuenta> lista;
    
    public ListaCuentas()
    {
        lista = new ArrayList<>();
    }

    public ArrayList<Cuenta> getLista()
    {
        return lista;
    }

    public void setLista(ArrayList<Cuenta> lista)
    {
        this.lista = lista;
    }
    
    public void crearCuenta(Cuenta c)
    {
        lista.add(c);
    }
    
    public boolean existeCuenta(Cuenta c)
    {
        return lista.contains(c);
    }
    
    public Cuenta obtenerCuenta(int posicion)
    {
        return lista.get(posicion);
    }
    
    public int obtenerIndiceCuenta(Cuenta c)
    {
        return lista.indexOf(c);
    }
    
    public ArrayList<Cuenta> obtenerCuentasTitular(String titular)
    {
        ArrayList<Cuenta> cuentasTitular = new ArrayList<>();
        
        for (Cuenta c : lista)
        {
            if (c.getTitular().equalsIgnoreCase(titular))
                cuentasTitular.add(c);
        }
        
        return cuentasTitular;
    }
    
    public double obtenerSaldoBanco()
    {
        double total = 0;
        
        for (Cuenta c : lista)
            total += c.getSaldo();
        
        return total;
    }
}
