package com.kreitek.pets.loggers;

public class Logger {
    private static int contador = 0;

    public void debug(String mensaje) {
        contador++;
        System.out.println("[debug][" + contador + "] - " + mensaje);
    }


    public static int getContador() {
        return contador;
    }


    public static void reiniciarContador() {
        contador = 0;
    }
}
