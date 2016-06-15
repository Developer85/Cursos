
package boutique;

import vista.MenuPrincipal;
import modelo.ListaPrendas;
import utilidades.Fichero;

/**
 *
 * @author usu21
 */
public class Boutique {
    public static Fichero miFichero;
    public static ListaPrendas misPrendas;
    public static MenuPrincipal menu;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        miFichero = new Fichero("boutique.xml");
        misPrendas = (ListaPrendas) miFichero.leer();
        if (misPrendas == null) misPrendas = new ListaPrendas();
        
        menu = new MenuPrincipal();
        menu.setVisible(true);
    }
}
