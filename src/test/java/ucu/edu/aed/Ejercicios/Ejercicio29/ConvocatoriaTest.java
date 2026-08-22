package ucu.edu.aed.Ejercicios.Ejercicio29;

import junit.framework.TestCase;
import ucu.edu.aed.implementaciones.TDAListaConArregloImpl;
import ucu.edu.aed.tda.TDALista;

public class ConvocatoriaTest extends TestCase {

    public void testPriorizaHabilitadosPorDivisionYPartidas() {
        TDALista<Jugador> jugadores = new TDAListaConArregloImpl<>();
        jugadores.agregar(new Jugador("A", Division.BRONCE, 10, Estado.HABILITADO));
        jugadores.agregar(new Jugador("B", Division.ORO, 20, Estado.HABILITADO));
        jugadores.agregar(new Jugador("C", Division.DIAMANTE, 30, Estado.HABILITADO));
        jugadores.agregar(new Jugador("D", Division.DIAMANTE, 5, Estado.HABILITADO));
        jugadores.agregar(new Jugador("E", Division.ORO, 15, Estado.HABILITADO));

        ResultadoConvocatoria resultado = new Convocatoria().armarConvocatoria(jugadores);

        assertEquals(5, resultado.getConvocados().tamanio());
        assertEquals(Division.DIAMANTE, resultado.getConvocados().obtener(0).getDivision());
        assertEquals(Division.DIAMANTE, resultado.getConvocados().obtener(1).getDivision());
        assertEquals(Division.ORO, resultado.getConvocados().obtener(2).getDivision());
        assertEquals(Division.ORO, resultado.getConvocados().obtener(3).getDivision());
        assertEquals(Division.BRONCE, resultado.getConvocados().obtener(4).getDivision());
        assertEquals(15, resultado.getDeficit());
    }

    public void testCompletaConvocatoriaConJugadoresNoHabilitados() {
        TDALista<Jugador> jugadores = new TDAListaConArregloImpl<>();

        for (int i = 0; i < 18; i++) {
            jugadores.agregar(new Jugador("H" + i, Division.PLATA, 7, Estado.HABILITADO));
        }

        jugadores.agregar(new Jugador("P1", Division.DIAMANTE, 2, Estado.LESIONADO));
        jugadores.agregar(new Jugador("P2", Division.ORO, 6, Estado.SUSPENDIDO));
        jugadores.agregar(new Jugador("P3", Division.PLATA, 9, Estado.LESIONADO));

        ResultadoConvocatoria resultado = new Convocatoria().armarConvocatoria(jugadores);

        assertEquals(20, resultado.getConvocados().tamanio());
        assertEquals(2, resultado.getConvocadosPendientes().tamanio());
        assertEquals(0, resultado.getDeficit());
        assertEquals(Estado.LESIONADO, resultado.getConvocadosPendientes().obtener(0).getEstado());
        assertEquals(Estado.SUSPENDIDO, resultado.getConvocadosPendientes().obtener(1).getEstado());
    }

    public void testDevuelveDeficitCuandoFaltanJugadores() {
        TDALista<Jugador> jugadores = new TDAListaConArregloImpl<>();
        jugadores.agregar(new Jugador("A", Division.BRONCE, 10, Estado.HABILITADO));
        jugadores.agregar(new Jugador("B", Division.PLATA, 8, Estado.HABILITADO));
        jugadores.agregar(new Jugador("C", Division.ORO, 7, Estado.HABILITADO));

        ResultadoConvocatoria resultado = new Convocatoria().armarConvocatoria(jugadores);

        assertEquals(3, resultado.getConvocados().tamanio());
        assertEquals(17, resultado.getDeficit());
        assertEquals(0, resultado.getConvocadosPendientes().tamanio());
    }

    public void testListaNulaLanzaExcepcion() {
        try {
            new Convocatoria().armarConvocatoria(null);
            fail("Se esperaba IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("La lista de jugadores no puede ser nula.", e.getMessage());
        }
    }
}
