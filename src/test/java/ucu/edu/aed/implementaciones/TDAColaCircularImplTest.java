package ucu.edu.aed.implementaciones;

import junit.framework.TestCase;

import java.util.NoSuchElementException;

/**
 * Casos de prueba para {@link TDAColaCircularConArregloImpl}, incluyendo
 * cola vacía, cola llena y wraparound del vector.
 */
public class TDAColaCircularImplTest extends TestCase {

    public void testColaNuevaEsVacia() {
        TDAColaCircularConArregloImpl<Integer> cola = new TDAColaCircularConArregloImpl<>(4);
        assertTrue(cola.esVacio());
        assertEquals(0, cola.tamanio());
    }

    public void testFrenteConColaVaciaLanzaExcepcion() {
        TDAColaCircularConArregloImpl<Integer> cola = new TDAColaCircularConArregloImpl<>(4);
        try {
            cola.frente();
            fail("Se esperaba NoSuchElementException");
        } catch (NoSuchElementException e) {
            // esperado
        }
    }

    public void testQuitaDeColaConColaVaciaLanzaExcepcion() {
        TDAColaCircularConArregloImpl<Integer> cola = new TDAColaCircularConArregloImpl<>(4);
        try {
            cola.quitaDeCola();
            fail("Se esperaba NoSuchElementException");
        } catch (NoSuchElementException e) {
            // esperado
        }
    }

    public void testPoneEnColaYFrente() {
        TDAColaCircularConArregloImpl<Integer> cola = new TDAColaCircularConArregloImpl<>(4);
        cola.poneEnCola(1);
        cola.poneEnCola(2);
        assertEquals(Integer.valueOf(1), cola.frente());
    }

    public void testColaLlenaLanzaExcepcion() {
        TDAColaCircularConArregloImpl<Integer> cola = new TDAColaCircularConArregloImpl<>(3);
        cola.poneEnCola(1);
        cola.poneEnCola(2);
        cola.poneEnCola(3);
        assertEquals(3, cola.tamanio());

        try {
            cola.poneEnCola(4);
            fail("Se esperaba IllegalStateException por cola llena");
        } catch (IllegalStateException e) {
            // esperado
        }
    }

    public void testWraparoundDelVector() {
        TDAColaCircularConArregloImpl<Integer> cola = new TDAColaCircularConArregloImpl<>(3);

        cola.poneEnCola(1); // [1, _, _]  fondo=1
        cola.poneEnCola(2); // [1, 2, _]  fondo=2
        assertEquals(Integer.valueOf(1), cola.quitaDeCola()); // frente avanza a 1

        cola.poneEnCola(3); // [_, 2, 3]  fondo=0 (dio la vuelta)
        cola.poneEnCola(4); // [4, 2, 3]  fondo=1 (ocupa la posicion 0, wraparound real)

        assertEquals(3, cola.tamanio());
        assertEquals(Integer.valueOf(2), cola.quitaDeCola());
        assertEquals(Integer.valueOf(3), cola.quitaDeCola());
        assertEquals(Integer.valueOf(4), cola.quitaDeCola());
        assertTrue(cola.esVacio());
    }

    public void testQuitarYVolverAPonerReutilizaEspacio() {
        TDAColaCircularConArregloImpl<Integer> cola = new TDAColaCircularConArregloImpl<>(2);
        cola.poneEnCola(1);
        cola.poneEnCola(2);
        assertEquals(2, cola.tamanio());

        cola.quitaDeCola();
        cola.poneEnCola(3);

        assertEquals(Integer.valueOf(2), cola.quitaDeCola());
        assertEquals(Integer.valueOf(3), cola.quitaDeCola());
    }
}