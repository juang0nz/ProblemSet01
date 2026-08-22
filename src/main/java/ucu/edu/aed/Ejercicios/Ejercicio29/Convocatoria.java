package ucu.edu.aed.Ejercicios.Ejercicio29;

import ucu.edu.aed.tda.TDALista;
import ucu.edu.aed.implementaciones.TDAListaConArregloImpl;

import java.util.Comparator;

public class Convocatoria {

    /**
     * Precondición: la lista recibida no es nula y cada jugador tiene división,
     * partidas jugadas y estado válidos.
     *
     * Postcondición: devuelve una instancia de ResultadoConvocatoria con hasta 20
     * titulares, los suplentes que quedaron fuera del grupo principal y la lista
     * de jugadores no habilitados que entraron como pendientes. Si la cantidad
     * total no alcanza 20, el déficit informa la cantidad faltante.
     *
     * Pseudocódigo:
     * 1. Separar jugadores habilitados y no habilitados.
     * 2. Ordenar habilitados por división descendente y partidas ascendentes.
     * 3. Ordenar no habilitados por división descendente.
     * 4. Tomar los 20 primeros habilitados como convocados.
     * 5. Los restantes habilitados pasan a suplentes.
     * 6. Si faltan jugadores, completar con no habilitados de mejor división.
     * 7. Devolver convocados, suplentes, pendientes y déficit.
     */
    public ResultadoConvocatoria armarConvocatoria(
            TDALista<Jugador> jugadores) {

        if (jugadores == null) {
            throw new IllegalArgumentException("La lista de jugadores no puede ser nula.");
        }

        TDALista<Jugador> habilitados = new TDAListaConArregloImpl<>();
        TDALista<Jugador> noHabilitados = new TDAListaConArregloImpl<>();

        for (int i = 0; i < jugadores.tamanio(); i++) {
            Jugador jugador = jugadores.obtener(i);

            if (jugador.getEstado() == Estado.HABILITADO) {
                habilitados.agregar(jugador);
            } else {
                noHabilitados.agregar(jugador);
            }
        }

        habilitados = habilitados.ordenar(comparadorHabilitados());
        noHabilitados = noHabilitados.ordenar(comparadorNoHabilitados());

        TDALista<Jugador> convocados = new TDAListaConArregloImpl<>();
        TDALista<Jugador> suplentes = new TDAListaConArregloImpl<>();
        TDALista<Jugador> convocadosPendientes = new TDAListaConArregloImpl<>();

        int i = 0;
        while (i < habilitados.tamanio() && convocados.tamanio() < 20) {
            convocados.agregar(habilitados.obtener(i));
            i++;
        }

        while (i < habilitados.tamanio()) {
            suplentes.agregar(habilitados.obtener(i));
            i++;
        }

        int j = 0;
        while (convocados.tamanio() < 20 && j < noHabilitados.tamanio()) {
            Jugador jugador = noHabilitados.obtener(j);
            convocados.agregar(jugador);
            convocadosPendientes.agregar(jugador);
            j++;
        }

        int deficit = 20 - convocados.tamanio();

        return new ResultadoConvocatoria(
                convocados,
                suplentes,
                convocadosPendientes,
                deficit);
    }

    /**
     * Orden de prioridad para habilitados:
     * mayor división primero; para igual división, menos partidas jugadas primero.
     */
    private Comparator<Jugador> comparadorHabilitados() {
        return new Comparator<Jugador>() {
            @Override
            public int compare(Jugador j1, Jugador j2) {
                if (j1.getDivision().ordinal() > j2.getDivision().ordinal()) {
                    return -1;
                }

                if (j1.getDivision().ordinal() < j2.getDivision().ordinal()) {
                    return 1;
                }

                if (j1.getPartidasJugadas() < j2.getPartidasJugadas()) {
                    return -1;
                }

                if (j1.getPartidasJugadas() > j2.getPartidasJugadas()) {
                    return 1;
                }

                return 0;
            }
        };
    }

    /**
     * Para lesionados y suspendidos solo importa la división.
     */
    private Comparator<Jugador> comparadorNoHabilitados() {
        return new Comparator<Jugador>() {
            @Override
            public int compare(Jugador j1, Jugador j2) {
                if (j1.getDivision().ordinal() > j2.getDivision().ordinal()) {
                    return -1;
                }

                if (j1.getDivision().ordinal() < j2.getDivision().ordinal()) {
                    return 1;
                }

                return 0;
            }
        };
    }
}