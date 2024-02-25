package ejercicios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TareaTest {

    @BeforeEach
    void setUp() {
        Tarea tarea1 = new Tarea("Tarea 1", "Descripción de la tarea 1", 30);
        Tarea tarea2 = new Tarea("Tarea 2", "Descripción de la tarea 2", 45);
        Tarea tarea3 = new Tarea("Tarea 3", "Descripción de la tarea 3", 60);
    }

    @Test
    void getNombre() {
    }

    @Test
    void getDescripcion() {
    }

    @Test
    void getTiempoEstimado() {
    }
}

