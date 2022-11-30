public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Numero de billetes vendidos
    private int numeroBilletesVendidos;
    // La maquina da premios o no
    private boolean premios;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(boolean daPremios, int precioDelBillete, String origen, String destino) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        numeroBilletesVendidos = 0;
        premios = daPremios;
    }
    
    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete el origen y el destino fijos.
     */
    public MaquinaExpendedoraMejorada(boolean daPremios) {
        precioBillete = 12;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = "Ponferrada";
        estacionDestino = "León";
        numeroBilletesVendidos = 0;
        premios = daPremios;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (cantidadIntroducida > 0) {
            balanceClienteActual = balanceClienteActual + cantidadIntroducida;
        }
        else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
        }        
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta;
        cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if (cantidadDeDineroQueFalta <= 0 ) {        
            // Simula la impresion de un billete
            System.out.println("##################");
            System.out.println("# Billete de tren:");
            System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
            System.out.println("# " + precioBillete + " euros.");
            System.out.println("##################");
            System.out.println();         
            // Actualiza el total de dinero acumulado en la maquina
            totalDineroAcumulado = totalDineroAcumulado + precioBillete;
            // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
            balanceClienteActual = balanceClienteActual - precioBillete;
            // Actualiza el numero de billetes vendidos
            numeroBilletesVendidos = numeroBilletesVendidos + 1;
            if (premios = true) {
            System.out.println("###############################################################");
            System.out.println("# Ha ganado un desvuento del 25% en todas las tienas de Inditex");
            System.out.println("###############################################################");
        }
        
        }
        else {
            System.out.println("###############################");
            System.out.println("# Faltan " + cantidadDeDineroQueFalta + " euros");
            System.out.println("###############################");
        }
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    }
    
    /**
     * Cuenta los billetes vendidos
     */
    public int getNumeroBilletesVendidos() { 
        return numeroBilletesVendidos;
    }
    
    /**
     * Imprime los billetes vendidos
     */
    public void imprimirNumeroBilletesVendidos() {
       System.out.println("# " + numeroBilletesVendidos + " billetes vendidos"); 
    }
    
    /**
     * Vacía todo el dinero que hay en ella
     */
    public int vaciarDineroDeLaMaquina() {
       int cantidadDeDineroAVaciar;
       cantidadDeDineroAVaciar = totalDineroAcumulado;
         if (balanceClienteActual == 0) { 
             totalDineroAcumulado = 0;
         }   
         else  {
             System.out.println("Error");
             cantidadDeDineroAVaciar = -1;
         }
         return cantidadDeDineroAVaciar;
    }
}