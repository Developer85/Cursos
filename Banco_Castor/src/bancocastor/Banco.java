// Clase Banco
package bancocastor;

import java.text.DecimalFormat;
import java.util.ArrayList;
import utilidades.EntradaDatos;
import utilidades.Fichero;

/**
 *
 * @author usu21
 */
public class Banco
{
    private ListaCuentas misCuentas;
    private Fichero miFichero;
    
    public Banco()
    {
        miFichero = new Fichero("banco.xml");
        misCuentas = (ListaCuentas) miFichero.leer();
        
        if (misCuentas == null)
        {
            misCuentas = new ListaCuentas();
            misCuentas.crearCuenta(new Cuenta(-2, "Banco Castor", 100000, false));
            miFichero.grabar(misCuentas);
        }

        mostrarMenu();
    }
    
    // Mostrar menú - FET
    private void mostrarMenu()
    {
        int opcion;
        
        do
        {
            System.out.println("Bienvenido al banco Castor\n");
            System.out.println("1. Alta cuenta");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Realizar transferencia");
            System.out.println("5. Consultar datos cuentas");
            System.out.println("6. Saldo total del banco");
            System.out.println("7. Salir");
            System.out.println("");
            opcion = EntradaDatos.pedirEntero("Escoge una opción: ", 1, 7);
            
            switch (opcion)
            {
                case 1:
                    Cuenta c = crearCuenta();                    
                    if (c == null) System.out.println("No se puede crear la cuenta.\n");
                    else
                    {
                        misCuentas.crearCuenta(c);
                        miFichero.grabar(misCuentas);
                        System.out.println("Cuenta dada de alta.\n");
                    }                    
                    break;
                case 2:
                    ingresarDinero();
                    break;
                case 3:
                    retirarDinero();
                    break;
                case 4:
                    transferirDinero();
                    break;
                case 5:
                    listarCuentas();
                    break;
                case 6:
                    saldoBanco();
                    break;
                case 7:
                    System.out.println("\n¡¡¡Ahorra mucho!!!");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        }
        while (opcion != 7);
    }
    
    // Alta cuenta - FET
    private Cuenta crearCuenta()
    {
        int num = EntradaDatos.pedirEntero("Introduce número de cuenta: ", 0, Integer.MAX_VALUE);
        Cuenta aux = new Cuenta(num);
        
        // Si no es troba cap compte amb el mateix núm. es demanen la resta de dades.
        if (misCuentas.existeCuenta(aux)) return null;
        else
        {
            String titular = EntradaDatos.pedirCadena("Introduce el titular: ", 1, 20);
            double saldo = EntradaDatos.pedirDecimal("Introduce el saldo: ", 1, Double.MAX_VALUE, "double");
            boolean personal = false;
            String respuesta;
            
            do
            {
                respuesta = EntradaDatos.pedirCadena("¿Es una cuenta personal (S/N)? ", 1, 1);
                if (respuesta.equalsIgnoreCase("S")) personal = true;
                else if (respuesta.equalsIgnoreCase("N")) personal = false;
            }
            while (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N"));
            
            return new Cuenta(num, titular, saldo, personal);
        }
    }
    
    // Ingresar dinero - FET
    private void ingresarDinero()
    {
        int num = EntradaDatos.pedirEntero("Introduce número de cuenta: ", 0, Integer.MAX_VALUE);
        Cuenta aux = new Cuenta(num);
        if (!misCuentas.existeCuenta(aux))
            System.out.println("Error!!! El número indicado no correspone a ninguna cuenta.\n");
        else
        {
            double cantidad = EntradaDatos.pedirDecimal("Introduce cantidad a ingresar: ", 0, 10000, "double");
            int indexCuenta = misCuentas.obtenerIndiceCuenta(aux);
            cantidad += misCuentas.obtenerCuenta(indexCuenta).getSaldo();
            misCuentas.obtenerCuenta(indexCuenta).setSaldo(cantidad);
            miFichero.grabar(misCuentas);
            System.out.println("Dinero ingresado.\n");
        }
    }
    
    // Retirar dinero - FET
    private void retirarDinero()
    {
        int num = EntradaDatos.pedirEntero("Introduce número de cuenta: ", 0, Integer.MAX_VALUE);
        Cuenta aux = new Cuenta(num);
        if (!misCuentas.existeCuenta(aux))
            System.out.println("Error!!! El número indicado no correspone a ninguna cuenta.\n");
        else
        {
            double cantidad = EntradaDatos.pedirDecimal("Introduce cantidad a retirar: ", 0, 10000, "double");
            int indexCuenta = misCuentas.obtenerIndiceCuenta(aux);
            double antiguoSaldo = misCuentas.obtenerCuenta(indexCuenta).getSaldo();
            double nuevoSaldo =  antiguoSaldo - cantidad;
            
            if (nuevoSaldo < 0) System.out.println("Error!!! Operación no permitida.\n");
            else
            {
                misCuentas.obtenerCuenta(indexCuenta).setSaldo(nuevoSaldo);
                miFichero.grabar(misCuentas);
                System.out.println("Dinero retirado.\n");
            }
        }
    }
    
    // Transferir dinero - FET
    private void transferirDinero()
    {
        int cuentaOrig = EntradaDatos.pedirEntero("Introduce número de cuenta origen: ", 0, Integer.MAX_VALUE);
        Cuenta c1 = new Cuenta(cuentaOrig);
        if (!misCuentas.existeCuenta(c1))
            System.out.println("Error!!! El número indicado no correspone a ninguna cuenta.\n");
        else
        {
            int cuentaDest = EntradaDatos.pedirEntero("Introduce número de cuenta destino: ", 0, Integer.MAX_VALUE);
            Cuenta c2 = new Cuenta(cuentaDest);
            if (!misCuentas.existeCuenta(c2))
                System.out.println("Error!!! El número indicado no correspone a ninguna cuenta.\n");
            else
            {
                double cantidad = EntradaDatos.pedirDecimal("Introduce cantidad a transferir: ", 0, 10000, "double");
                int indexOrig = misCuentas.obtenerIndiceCuenta(c1);
                double comision = cantidad * misCuentas.obtenerCuenta(indexOrig).getComision();
                double totalTransfer = cantidad + comision;
                double saldoC1 = misCuentas.obtenerCuenta(indexOrig).getSaldo() - totalTransfer;
                
                if (saldoC1 < 0) System.out.println("Error!!! Operación no permitida.\n");
                else
                {
                    int indexDestino = misCuentas.obtenerIndiceCuenta(c2);
                    double saldoC2 = misCuentas.obtenerCuenta(indexDestino).getSaldo() + cantidad;
                    misCuentas.obtenerCuenta(indexOrig).setSaldo(saldoC1);
                    misCuentas.obtenerCuenta(indexDestino).setSaldo(saldoC2);
                    miFichero.grabar(misCuentas);
                    
                    System.out.println("\nCuenta Origen\n" + misCuentas.obtenerCuenta(indexOrig));
                    System.out.println("Cuenta Destino\n" + misCuentas.obtenerCuenta(indexDestino));
                }
            }
        }
    }
    
    // Consultar datos cuenta - FET
    private void listarCuentas()
    {
        String titular = EntradaDatos.pedirCadena("Introduce el titular: ", 1, 20);
        ArrayList<Cuenta> cuentasTitular = misCuentas.obtenerCuentasTitular(titular);
        
        if (cuentasTitular.isEmpty())
            System.out.println("Lo siento. No se ha encontrado ninguna cuenta con el titular indicado.\n");
        else
        {
            for (Cuenta c : cuentasTitular)
                System.out.println(c);
        }
    }
    
    // Saldo total del banco - FET
    private void saldoBanco()
    {
        DecimalFormat df = new DecimalFormat("#,###.00");
        double total = misCuentas.obtenerSaldoBanco();        
        System.out.println("\nSaldo Total: " + df.format(total) + "\n");
    }
}
