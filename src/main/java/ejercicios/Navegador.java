package ejercicios;
import java.util.Arrays;

public class Navegador {
    public static void main(String[] args) {
        // Generar terreno y obstáculos de ejemplo
        int[][] terreno = {
                {0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };

        int[][] obstaculos = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        // Calcular ruta de exploración
        int[][] rutaExploracion = calcularRutaExploracion(terreno, obstaculos);

        // Visualizar resultados
        System.out.println("Terreno:");
        visualizarMatriz(terreno);
        System.out.println("Obstáculos:");
        visualizarMatriz(obstaculos);
        System.out.println("Ruta de exploración:");
        visualizarMatriz(rutaExploracion);
    }

    // Función para calcular la ruta de exploración
    private static int[][] calcularRutaExploracion(int[][] terreno, int[][] obstaculos) {
        int filas = terreno.length;
        int columnas = terreno[0].length;

        int[][] rutaExploracion = new int[filas][columnas];

        // Inicializar ruta de exploración con el mismo valor que el terreno
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                rutaExploracion[i][j] = terreno[i][j];
            }
        }

        // Marcar obstáculos en la ruta de exploración
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (obstaculos[i][j] == 1) {
                    rutaExploracion[i][j] = 1; // Marcar como obstáculo
                }
            }
        }

        return rutaExploracion;
    }

    // Función para visualizar una matriz
    private static void visualizarMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            System.out.println(Arrays.toString(fila));
        }
        System.out.println();
    }
}


