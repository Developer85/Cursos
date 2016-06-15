
package boutique;

import utilidades.Fichero;

/**
 *
 * @author usu21
 */
public class Boutique {
    public static Fichero miFichero;
    public static ListaPrendas misPrendas;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        miFichero = new Fichero("boutique.xml");
        misPrendas = (ListaPrendas) miFichero.leer();
        if (misPrendas == null) misPrendas = new ListaPrendas();
        
        GUI_MenuPrincipal menu = new GUI_MenuPrincipal();
        menu.setVisible(true);
    }
}
