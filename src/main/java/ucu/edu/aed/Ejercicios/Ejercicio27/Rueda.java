package ucu.edu.aed.Ejercicios.Ejercicio27;

import ucu.edu.aed.implementaciones.TDAListaDobleEnlazadaImpl;
import ucu.edu.aed.tda.TDALista;

public class Rueda {

    private TDALista<Cabina> cabinas;
    private int posicionActual;

    public Rueda(int cantidadCabinas, int capacidadCabina) {

        if (cantidadCabinas <= 0 || capacidadCabina < 0) {
            throw new IllegalArgumentException("Parámetros inválidos");
        }

        cabinas = new TDAListaDobleEnlazadaImpl<>();

        for (int i = 0; i < cantidadCabinas; i++) {
            cabinas.agregar(new Cabina(capacidadCabina));
        }

        posicionActual = 0;
    }

    public boolean avanzar() {

        if (cabinas.esVacio()) {
            return false;
        }

        posicionActual++;

        if (posicionActual >= cabinas.tamanio()) {
            posicionActual = 0;
        }

        return true;
    }

    public boolean subirPasajeros(int cantidad) {

        if (cabinas.esVacio()) {
            return false;
        }

        Cabina cabina = cabinas.obtener(posicionActual);

        return cabina.subir(cantidad);
    }

    public boolean bajarPasajeros() {

        if (cabinas.esVacio()) {
            return false;
        }

        Cabina cabina = cabinas.obtener(posicionActual);

        return cabina.bajar(cabina.getOcupacion());
    }
}