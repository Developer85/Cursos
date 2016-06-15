
package utilidades;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author usu21
 */
public class DatosComunes {
    public static ArrayList<String> obtenerPaises() {
        ArrayList<String> paises = new ArrayList<>();
        paises.add("Cataluña");
        paises.add("Andorra");
        paises.add("Francia");
        paises.add("España");
        paises.add("Italia");
        paises.add("Alemania");
        paises.add("Inglaterra");
        paises.add("Ucrania");
        paises.add("Serbia");
        paises.add("Croacia");
        paises.add("Bélgica");
        paises.add("Holanda");
        paises.add("-- Escoge un país --");
        Collections.sort(paises);
        return paises;
    }
}
