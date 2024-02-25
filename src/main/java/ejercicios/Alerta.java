import java.util.ArrayList;
import java.util.List;


class VariableAmbiental {
    private String nombre;
    private double valor;
    private double limiteInferior;
    private double limiteSuperior;

    public VariableAmbiental(String nombre, double limiteInferior, double limiteSuperior) {
        this.nombre = nombre;
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
        this.valor = 0; // Valor inicial
    }

    public void actualizarValor(double valor) {
        this.valor = valor;
    }

    public boolean esValorSeguro() {
        return valor >= limiteInferior && valor <= limiteSuperior;
    }

    public String getNombre() {
        return nombre;
    }

    public double getValor() {
        return valor;
    }
}


class SistemaAlerta {
    private List<VariableAmbiental> variables;

    public SistemaAlerta() {
        this.variables = new ArrayList<>();
    }

    public void agregarVariable(VariableAmbiental variable) {
        variables.add(variable);
    }

    public void monitorearVariables() {
        for (VariableAmbiental variable : variables) {
            if (!variable.esValorSeguro()) {
                System.out.println("¡Alerta! " + variable.getNombre() + " fuera de rango seguro. Valor: " + variable.getValor());

            }
        }
    }
}

// Clase para identificar números primos
class IdentificadorPrimos {
    public List<Integer> encontrarPrimos(int n) {
        boolean[] esPrimo = new boolean[n + 1];
        List<Integer> primos = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            esPrimo[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (esPrimo[p]) {
                for (int i = p * p; i <= n; i += p) {
                    esPrimo[i] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (esPrimo[i]) {
                primos.add(i);
            }
        }

        return primos;
    }
}


class DescomponedorFactores {
    public List<Integer> descomponerEnFactoresPrimos(int numero) {
        List<Integer> factores = new ArrayList<>();
        int divisor = 2;

        while (numero > 1) {
            while (numero % divisor == 0) {
                factores.add(divisor);
                numero /= divisor;
            }
            divisor++;
        }

        return factores;
    }
}

public class Alerta {
    public static void main(String[] args) {
        // Crear variables ambientales críticas
        VariableAmbiental radiacion = new VariableAmbiental("Radiación", 0, 100);
        VariableAmbiental temperatura = new VariableAmbiental("Temperatura", 20, 30);
        VariableAmbiental presion = new VariableAmbiental("Presión", 800, 1200);

        // Crear sistema de alerta
        SistemaAlerta sistemaAlerta = new SistemaAlerta();
        sistemaAlerta.agregarVariable(radiacion);
        sistemaAlerta.agregarVariable(temperatura);
        sistemaAlerta.agregarVariable(presion);

        // Simular cambios en las variables ambientales críticas
        radiacion.actualizarValor(110);
        temperatura.actualizarValor(35);
        presion.actualizarValor(700);

        // Monitorear variables y emitir alertas
        sistemaAlerta.monitorearVariables();

        // Identificar y listar los primeros 10 números primos
        IdentificadorPrimos identificadorPrimos = new IdentificadorPrimos();
        List<Integer> primerosPrimos = identificadorPrimos.encontrarPrimos(30);
        System.out.println("Primeros 10 números primos: " + primerosPrimos);

        // Descomponer un número en factores primos
        DescomponedorFactores descomponedor = new DescomponedorFactores();
        List<Integer> factoresPrimos = descomponedor.descomponerEnFactoresPrimos(84);
        System.out.println("Factores primos de 84: " + factoresPrimos);
    }
}



