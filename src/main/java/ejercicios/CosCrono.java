package ejercicios;

import java.util.Scanner;

public class CosCrono {
    // Constantes para el planeta Tierra
    private static final int TIERRA_SEGUNDOS_POR_MINUTO = 60;
    private static final int TIERRA_MINUTOS_POR_HORA = 60;
    private static final int TIERRA_HORAS_POR_DIA = 24;
    private static final int TIERRA_DIAS_POR_ANIO = 365;

    // Constantes para el nuevo planeta inventado
    private static final int NUEVO_PLANETA_SEGUNDOS_POR_MINUTO = 50;
    private static final int NUEVO_PLANETA_MINUTOS_POR_HORA = 60;
    private static final int NUEVO_PLANETA_HORAS_POR_DIA = 20;
    private static final int NUEVO_PLANETA_DIAS_POR_ANIO = 300;


    public static void convertirTiempo(double segundos, int segundosPorMinuto, int minutosPorHora, int horasPorDia, int diasPorAnio) {

        double minutos = segundos / segundosPorMinuto;
        double horas = minutos / minutosPorHora;
        double dias = horas / horasPorDia;
        double anios = dias / diasPorAnio;


        System.out.println("Años: " + (int) anios);
        System.out.println("Días: " + (int) dias % diasPorAnio);
        System.out.println("Horas: " + (int) horas % horasPorDia);
        System.out.println("Minutos: " + (int) minutos % minutosPorHora);
        System.out.println("Segundos: " + (int) segundos % segundosPorMinuto);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la cantidad de segundos: ");
        double tiempoEnSegundos = scanner.nextDouble();

        //  planeta Tierra
        System.out.println("Tiempo en el planeta Tierra:");
        convertirTiempo(tiempoEnSegundos, TIERRA_SEGUNDOS_POR_MINUTO, TIERRA_MINUTOS_POR_HORA, TIERRA_HORAS_POR_DIA, TIERRA_DIAS_POR_ANIO);

        //  nuevo planeta
        System.out.println("\nTiempo en el nuevo:");
        convertirTiempo(tiempoEnSegundos, NUEVO_PLANETA_SEGUNDOS_POR_MINUTO, NUEVO_PLANETA_MINUTOS_POR_HORA, NUEVO_PLANETA_HORAS_POR_DIA, NUEVO_PLANETA_DIAS_POR_ANIO);
    }
}
