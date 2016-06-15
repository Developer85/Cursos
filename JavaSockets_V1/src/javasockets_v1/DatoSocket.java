package javasockets_v1;

import java.io.Serializable;

public class DatoSocket implements Serializable {
    private String nombre;
    private int numero;
    private boolean acierto;
    
    public DatoSocket() {
        nombre = "";
        numero = 0;
    }

    public DatoSocket(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isAcierto() {
        return acierto;
    }

    public void setAcierto(boolean acierto) {
        this.acierto = acierto;
    }

    @Override
    public String toString() {
        //return "Nombre --> " + nombre + ", Número --> " + String.valueOf(numero);
        String info = nombre + ", ";
        if (acierto) info += "HAS ACERTADO.";
        else info += "NO HAS ACERTADO.";
        
        return info;
    }
}
