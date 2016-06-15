
package utilidades;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author usuari
 */
public class Fichero {
    private String nombre;
    
    public Fichero(String nombre) {
        this.nombre = nombre;
    }
    
    public void grabar(Object o) {
        try {
            XMLEncoder codificador = new XMLEncoder(new FileOutputStream(new File(nombre)));
            codificador.writeObject(o);
            codificador.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error!!! No se ha encontrado el fichero.\n");
        }
    }
    
    public Object leer() {
        try {
            XMLDecoder decodificador = new XMLDecoder(new FileInputStream(new File(nombre)));
            return decodificador.readObject();
        } catch (FileNotFoundException ex) {
            return null;
        }
    }
}
