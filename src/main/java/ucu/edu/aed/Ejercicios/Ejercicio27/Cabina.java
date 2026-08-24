package ucu.edu.aed.Ejercicios.Ejercicio27;

public class Cabina {

    private int capacidad;
    private int pasajeros;

    public Cabina(int capacidad) {
        if (capacidad < 0) {
            throw new IllegalArgumentException("La capacidad no puede ser negativa");
        }

        this.capacidad = capacidad;
        this.pasajeros = 0;
    }

    public boolean subir(int cantidad) {

        if (cantidad < 0) {
            return false;
        }

        if (pasajeros + cantidad > capacidad) {
            return false;
        }

        pasajeros += cantidad;
        return true;
    }

    public boolean bajar(int cantidad) {

        if (cantidad < 0 || cantidad > pasajeros) {
            return false;
        }

        pasajeros -= cantidad;
        return true;
    }

    public int getOcupacion() {
        return pasajeros;
    }

    public int setOcupacion(int nuevaOcupacion) {

        if (nuevaOcupacion < 0 || nuevaOcupacion > capacidad) {
            throw new IllegalArgumentException(
                    "La ocupación debe estar entre 0 y la capacidad máxima"
            );
        }

        pasajeros = nuevaOcupacion;
        return pasajeros;
    }
}