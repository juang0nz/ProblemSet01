package ucu.edu.aed.Ejercicios.Ejercicio29;

import ucu.edu.aed.tda.TDALista;

public class ResultadoConvocatoria {

    final TDALista<Jugador> convocados;
    final TDALista<Jugador> suplentes;
    final TDALista<Jugador> convocadosPendientes;
    final int deficit;

    public ResultadoConvocatoria(
            TDALista<Jugador> convocados,
            TDALista<Jugador> suplentes,
            TDALista<Jugador> convocadosPendientes,
            int deficit) {

        this.convocados = convocados;
        this.suplentes = suplentes;
        this.convocadosPendientes = convocadosPendientes;
        this.deficit = deficit;
    }

    public TDALista<Jugador> getConvocados() {
        return convocados;
    }

    public TDALista<Jugador> getSuplentes() {
        return suplentes;
    }

    public TDALista<Jugador> getConvocadosPendientes() {
        return convocadosPendientes;
    }

    public int getDeficit() {
        return deficit;
    }
}