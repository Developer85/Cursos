
package utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author usu21
 */
public abstract class EntradaDatos {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static String pedirCadena(String mensaje, int minLong, int maxLong) {
        String cadena = "";
        boolean error = true;
        
        while (error) {    
            try {
                System.out.print(mensaje);
                cadena = br.readLine();
                if (cadena.length() < minLong || cadena.length() > maxLong)
                    System.out.println("Error!!! Tamaño de cadena incorrecto.");
                else error = false;
            } catch (IOException ex) {
                System.out.println("Error!!! Se ha producido un error de E/S.");
            }
        }
        
        return cadena;
    }
    
    public static int pedirEntero(String mensaje, int min, int max) {
        int numero = -1;
        boolean error = true;

        while (error) {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(br.readLine());
                if (numero < min || numero > max)
                    System.out.println("Error!!! Número fuera de rango.");
                else error = false;                
            } catch (NumberFormatException ex) {
                System.out.println("Error!!! Número incorrecto.");
            } catch (IOException ex) {
                System.out.println("Error!!! Se ha producido un error de E/S.");
            }
        }
        
        return numero;
    }
    
    public static double pedirDecimal(String mensaje, double min, double max, String tipo) {
        double numero = -1;
        boolean error = true;

        while (error) {
            try {
                System.out.print(mensaje);
                numero = Double.parseDouble(br.readLine());
                if (numero < min || numero > max)
                    System.out.println("Error!!! Número fuera de rango.");
                else error = false;                
            } catch (NumberFormatException ex) {
                System.out.println("Error!!! Número incorrecto.");
            } catch (IOException ex) {
                System.out.println("Error!!! Se ha producido un error de E/S.");
            }
        }
        
        if (tipo.equalsIgnoreCase("float")) return (float) numero;
        else return numero;
    }
    
    public static boolean esEntero(String valor) {
        try {
            int num = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    
    public static boolean esDecimal(String valor) {
        try {
            double num = Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
