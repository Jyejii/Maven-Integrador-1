import java.util.Scanner;

public class Recursos {
    private int totalAgua;
    private int totalComida;
    private int totalOxigeno;
    private int dias;

    public Recursos() {
        totalAgua = 0;
        totalComida = 0;
        totalOxigeno = 0;
        dias = 0;
    }

    public void agregarConsumoDiario(int agua, int comida, int oxigeno) {
        totalAgua += agua;
        totalComida += comida;
        totalOxigeno += oxigeno;
        dias++;
    }

    public double calcularMedia(String recurso) {
        if (dias == 0) {
            return 0.0;
        }

        if (recurso.equals("agua")) {
            return (double) totalAgua / dias;
        } else if (recurso.equals("comida")) {
            return (double) totalComida / dias;
        } else if (recurso.equals("oxigeno")) {
            return (double) totalOxigeno / dias;
        } else {
            return 0.0;
        }
    }

    public int calcularMinimo(String recurso) {
        if (dias == 0) {
            return 0;
        }

        if (recurso.equals("agua")) {
            return totalAgua / dias;
        } else if (recurso.equals("comida")) {
            return totalComida / dias;
        } else if (recurso.equals("oxigeno")) {
            return totalOxigeno / dias;
        } else {
            return 0;
        }
    }

    public int calcularMaximo(String recurso) {
        if (dias == 0) {
            return 0;
        }

        if (recurso.equals("agua")) {
            return totalAgua / dias;
        } else if (recurso.equals("comida")) {
            return totalComida / dias;
        } else if (recurso.equals("oxigeno")) {
            return totalOxigeno / dias;
        } else {
            return 0;
        }
    }

    public boolean activarAlerta(String recurso, int umbral) {
        if (recurso.equals("agua")) {
            return totalAgua < umbral;
        } else if (recurso.equals("comida")) {
            return totalComida < umbral;
        } else if (recurso.equals("oxigeno")) {
            return totalOxigeno < umbral;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Recursos sistema = new Recursos();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Ingrese consumo de agua del día:");
            int agua = obtenerEntero(scanner);
            System.out.println("Ingrese consumo de comida del día:");
            int comida = obtenerEntero(scanner);
            System.out.println("Ingrese consumo de oxígeno del día:");
            int oxigeno = obtenerEntero(scanner);
            sistema.agregarConsumoDiario(agua, comida, oxigeno);
        }

        System.out.println("\nEstadísticas del consumo de recursos en los últimos 5 días:");
        String[] recursos = {"agua", "comida", "oxigeno"};
        for (String recurso : recursos) {
            System.out.println("Recurso: " + recurso);
            System.out.println("Media: " + sistema.calcularMedia(recurso));
            System.out.println("Mínimo: " + sistema.calcularMinimo(recurso));
            System.out.println("Máximo: " + sistema.calcularMaximo(recurso));
            System.out.println("Alerta: " + sistema.activarAlerta(recurso, 10));
            System.out.println();
        }

        scanner.close();
    }

    private static int obtenerEntero(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Entrada no válida. Intente nuevamente.");
                scanner.nextLine();
            }
        }
    }
}


