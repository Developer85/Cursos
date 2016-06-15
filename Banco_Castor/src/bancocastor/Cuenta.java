// Clase Cuenta
package bancocastor;

import java.text.DecimalFormat;

/**
 *
 * @author usu21
 */
public class Cuenta
{
    private int numero;
    private String titular;
    private double saldo;
    private double comision;
    private boolean personal;

    public Cuenta(int numero, String titular, double saldo, boolean personal)
    {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.personal = personal;
        if (personal) comision = 0.05;
        else comision = 0.02;
    }
    
    public Cuenta(int numero)
    {
        this.numero = numero;
        titular = "";
        saldo = -1;
        comision = -1;
        personal = true;
    }
    
    public Cuenta() {}
    
    @Override
    public String toString()
    {
        DecimalFormat df = new DecimalFormat("#,###.00");
        StringBuilder info = new StringBuilder();
        info.append("\nDatos de la cuenta\n\n");
        info.append("Número: ").append(numero).append("\n");
        info.append("Titular: ").append(titular).append("\n");
        info.append("Saldo: ").append(df.format(saldo)).append("\n");
        info.append("Comisión: ").append(comision).append(" ");
        
        if (isPersonal()) info.append("Cuenta Personal");
        else info.append("Cuenta de Empresa");
        
        return info.toString();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        final Cuenta other = (Cuenta) obj;
        return (numero == other.numero); 
    }
    
    public int getNumero()
    {
        return numero;
    }

    public void setNumero(int numero)
    {
        this.numero = numero;
    }
    
    public String getTitular()
    {
        return titular;
    }
    
    public void setTitular(String titular)
    {
        this.titular = titular;
    }
    
    public double getSaldo()
    {
        return saldo;
    }
    
    public void setSaldo(double saldo)
    {
        this.saldo = saldo;
    }
    
    public boolean isPersonal()
    {
        return personal;
    }
    
    public void setPersonal(boolean personal)
    {
        this.personal = personal; 
    }
    
    public double getComision()
    {
        return comision;
    }
    
    public void setComision(double comision)
    {
        this.comision = comision;
    }
}
