package ucu.edu.aed.Ejercicios.Ejercicio29;

import ucu.edu.aed.implementaciones.TDAListaConArregloImpl;
import ucu.edu.aed.tda.TDALista;

public class Main {

    public static void main(String[] args) {

        // Catálogo de jugadores.
        // El orden en que los agregamos representa
        // el orden en que se registraron.
        TDALista<Jugador> jugadores = new TDAListaConArregloImpl<>();

        // Creamos algunos jugadores habilitados.
        jugadores.agregar(new Jugador("Juan", Division.ORO, 50, Estado.HABILITADO));
        jugadores.agregar(new Jugador("Pedro", Division.DIAMANTE, 100, Estado.HABILITADO));
        jugadores.agregar(new Jugador("Ana", Division.ORO, 20, Estado.HABILITADO));
        jugadores.agregar(new Jugador("Lucas", Division.PLATINO, 30, Estado.HABILITADO));
        jugadores.agregar(new Jugador("Sofia", Division.PLATA, 10, Estado.HABILITADO));
        jugadores.agregar(new Jugador("Diego", Division.ORO, 40, Estado.HABILITADO));
        jugadores.agregar(new Jugador("Valentina", Division.DIAMANTE, 60, Estado.HABILITADO));
        jugadores.agregar(new Jugador("Martín", Division.PLATINO, 80, Estado.HABILITADO));
        jugadores.agregar(new Jugador("Camila", Division.PLATA, 15, Estado.HABILITADO));
        jugadores.agregar(new Jugador("Javier", Division.ORO, 25, Estado.HABILITADO));
        jugadores.agregar(new Jugador("Lucía", Division.DIAMANTE, 70, Estado.HABILITADO));
        jugadores.agregar(new Jugador("Andrés", Division.PLATINO, 90, Estado.HABILITADO));
        jugadores.agregar(new Jugador("Isabella", Division.PLATA, 5, Estado.HABILITADO));
        jugadores.agregar(new Jugador("Santiago", Division.ORO, 35, Estado.HABILITADO));
        jugadores.agregar(new Jugador("Martina", Division.DIAMANTE, 55, Estado.HABILITADO));
        jugadores.agregar(new Jugador("Tomás", Division.PLATINO, 75, Estado.HABILITADO));

        // Agregamos lesionados y suspendidos.
        jugadores.agregar(new Jugador("Maria", Division.DIAMANTE, 40, Estado.LESIONADO));
        jugadores.agregar(new Jugador("Carlos", Division.PLATA, 10, Estado.SUSPENDIDO));
        jugadores.agregar(new Jugador("Lucia", Division.ORO, 20, Estado.LESIONADO));
        jugadores.agregar(new Jugador("Diego", Division.PLATINO, 30, Estado.SUSPENDIDO));
        jugadores.agregar(new Jugador("Sofia", Division.DIAMANTE, 50, Estado.LESIONADO));

        // Creamos el gestor de convocatoria.
        Convocatoria convocatoria = new Convocatoria();

        // Armamos la convocatoria.
        ResultadoConvocatoria resultado = convocatoria.armarConvocatoria(jugadores);

        // CONVOCADOS

        System.out.println("=== CONVOCADOS ===");

        for (int i = 0; i < resultado.getConvocados().tamanio(); i++) {

            System.out.println(
                    resultado.getConvocados().obtener(i));
        }

        // SUPLENTES

        System.out.println("\n=== SUPLENTES ===");

        for (int i = 0; i < resultado.getSuplentes().tamanio(); i++) {

            System.out.println(
                    resultado.getSuplentes().obtener(i));
        }

        // CONVOCADOS PENDIENTES

        System.out.println("\n=== CONVOCADOS PENDIENTES ===");

        for (int i = 0; i < resultado.getConvocadosPendientes().tamanio(); i++) {

            System.out.println(
                    resultado.getConvocadosPendientes().obtener(i));
        }

        // DÉFICIT

        System.out.println("\n=== DEFICIT ===");

        System.out.println(
                "Faltan " + resultado.getDeficit()
                        + " jugadores para completar los 20.");
    }
}