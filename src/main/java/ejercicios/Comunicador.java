package ejercicios;

public class Comunicador{
    public static void main(String[] args) {
        String mensaje = "Integrar la harina con la sal.";

        // Contar vocales
            int numeroVocales = contarVocales(mensaje);
            System.out.println("Número de vocales en el mensaje: " + numeroVocales);

        // Invertir mensaje
        String mensajeInvertido = invertirMensaje(mensaje);
        System.out.println("Mensaje invertido: " + mensajeInvertido);

        // Verificar si el mensaje es un palíndromo
        boolean esPalindromo = esPalindromo(mensaje);
        if (esPalindromo) {
            System.out.println("El mensaje es un palíndromo.");
        } else {
            System.out.println("El mensaje no es un palíndromo.");
        }
    }
    public static int contarVocales(String mensaje) {
        int contador = 0;
        mensaje = mensaje.toLowerCase(); // Convertir mensaje a minúsculas para simplificar conteo
        for (int i = 0; i < mensaje.length(); i++) {
            char caracter = mensaje.charAt(i);
            if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u') {
                contador++;
            }
        }
        return contador;
    }

    public static String invertirMensaje(String mensaje) {
        StringBuilder builder = new StringBuilder(mensaje);
        return builder.reverse().toString();
    }

    // Función para verificar si un mensaje es un palíndromo
    public static boolean esPalindromo(String mensaje) {
        // Eliminar espacios y convertir a minúsculas para simplificar la comparación
        mensaje = mensaje.replaceAll("\\s", "").toLowerCase();
        int longitud = mensaje.length();
        for (int i = 0; i < longitud / 2; i++) {
            if (mensaje.charAt(i) != mensaje.charAt(longitud - i - 1)) {
                return false;
            }
        }
        return true;
    }
}

