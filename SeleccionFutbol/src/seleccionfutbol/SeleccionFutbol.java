/*
 * Ejemplo con Herencia y Diferentes relaciones entre clases (1-1, 1-n)
 */
package seleccionfutbol;

import modelo.ListaEntrenadores;
import modelo.ListaEquipos;
import modelo.ListaJugadores;
import utilidades.Fichero;
import vista.MenuPrincipal;

/**
 *
 * @author mfontana
 */
public class SeleccionFutbol {    
    public static ListaJugadores todosJugadores;
    public static Fichero ficheroJugadores;
    public static ListaEntrenadores todosEntrenadores;
    public static Fichero ficheroEntrenadores;
    public static ListaEquipos todosEquipos;
    public static Fichero ficheroEquipos;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ficheroJugadores = new Fichero("jugadores.xml");
        todosJugadores = (ListaJugadores) ficheroJugadores.leer();
        if (todosJugadores == null) todosJugadores = new ListaJugadores();
        
        ficheroEntrenadores = new Fichero("entrenadores.xml");
        todosEntrenadores = (ListaEntrenadores) ficheroEntrenadores.leer();
        if (todosEntrenadores == null ) todosEntrenadores = new ListaEntrenadores();
        
        ficheroEquipos = new Fichero("equipos.xml");
        todosEquipos = (ListaEquipos) ficheroEquipos.leer();
        if (todosEquipos == null ) todosEquipos = new ListaEquipos();
        
        MenuPrincipal mp = new MenuPrincipal();
        mp.setVisible(true);
    }
}
