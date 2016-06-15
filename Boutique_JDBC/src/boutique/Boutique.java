
package boutique;

import dao.PrendaJDBC;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import vista.MenuPrincipal;

/**
 *
 * @author usu21
 */
public class Boutique {
    public static MenuPrincipal menu;
    public static PrendaJDBC prendasFuente;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        prendasFuente = new PrendaJDBC();        
        menu = new MenuPrincipal();
        menu.setVisible(true);
    }
    
    public static void configurarTabla(JTable tabla) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabla.getModel());
        tabla.setRowSorter(sorter);
    }
}
