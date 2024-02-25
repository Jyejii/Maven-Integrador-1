package ejercicios;

import java.util.ArrayList;
import java.util.List;

// Clase para representar una tarea
class Tarea {
    private String nombre;
    private String descripcion;
    private int tiempoEstimado; // En minutos

    public Tarea(String nombre, String descripcion, int tiempoEstimado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tiempoEstimado = tiempoEstimado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }
}

// Clase para el planificador de tareas
class PlanificadorTareas {
    private List<Tarea> tareas;
    private List<String> miembros;
    private int[][] asignaciones; // Matriz para representar las asignaciones de tareas (miembros x tareas)

    public PlanificadorTareas() {
        tareas = new ArrayList<>();
        miembros = new ArrayList<>();
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public void agregarMiembro(String miembro) {
        miembros.add(miembro);
    }

    public void distribuirTareas() {
        int cantidadMiembros = miembros.size();
        int cantidadTareas = tareas.size();

        asignaciones = new int[cantidadMiembros][cantidadTareas];

        // Distribuir equitativamente las tareas entre los miembros
        for (int i = 0; i < cantidadTareas; i++) {
            asignaciones[i % cantidadMiembros][i] = 1;
        }

        // Mostrar tablas de tareas
        System.out.println("Tablas de tareas:");
        for (int i = 0; i < cantidadMiembros; i++) {
            System.out.println("Miembro: " + miembros.get(i));
            System.out.println("Tareas asignadas:");
            for (int j = 0; j < cantidadTareas; j++) {
                if (asignaciones[i][j] == 1) {
                    Tarea tarea = tareas.get(j);
                    System.out.println("- " + tarea.getNombre() + ": " + tarea.getDescripcion() + " - Tiempo estimado: " + tarea.getTiempoEstimado() + " minutos");
                }
            }
            System.out.println();
        }
    }

    public int calcularCargaTrabajoOptima() {
        int cargaTotal = 0;

        for (Tarea tarea : tareas) {
            cargaTotal += tarea.getTiempoEstimado();
        }

        return cargaTotal / miembros.size();
    }
}

public class Tareas {
    public static void main(String[] args) {
        // Crear tareas
        Tarea tarea1 = new Tarea("Tarea 1", "Descripción de la tarea 1", 30);
        Tarea tarea2 = new Tarea("Tarea 2", "Descripción de la tarea 2", 45);
        Tarea tarea3 = new Tarea("Tarea 3", "Descripción de la tarea 3", 60);

        // Crear planificador de tareas
        PlanificadorTareas planificador = new PlanificadorTareas();

        // Agregar tareas al planificador
        planificador.agregarTarea(tarea1);
        planificador.agregarTarea(tarea2);
        planificador.agregarTarea(tarea3);

        // Agregar miembros de la tripulación
        planificador.agregarMiembro("Miembro 1");
        planificador.agregarMiembro("Miembro 2");

        // Distribuir tareas entre los miembros y mostrar tablas de tareas
        planificador.distribuirTareas();

        // Calcular carga de trabajo óptima
        int cargaOptima = planificador.calcularCargaTrabajoOptima();
        System.out.println("Carga de trabajo óptima por miembro: " + cargaOptima + " minutos");
    }
}
