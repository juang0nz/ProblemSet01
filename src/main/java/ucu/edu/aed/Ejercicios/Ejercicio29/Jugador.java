package ucu.edu.aed.Ejercicios.Ejercicio29;

public class Jugador implements Comparable<Jugador> {

    private String nombre;
    private Division division;
    private int partidasJugadas;
    private Estado estado;

    public Jugador(
            String nombre,
            Division division,
            int partidasJugadas,
            Estado estado) {

        this.nombre = nombre;
        this.division = division;
        this.partidasJugadas = partidasJugadas;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas(int partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Orden de prioridad para habilitados:
     * 1) mayor división,
     * 2) menor cantidad de partidas,
     * 3) si hay empate, se conserva el orden de ingreso.
     */
    @Override
    public int compareTo(Jugador otro) {
        if (otro == null) {
            return 1;
        }

        if (this.division.ordinal() != otro.division.ordinal()) {
            return Integer.compare(otro.division.ordinal(), this.division.ordinal());
        }

        if (this.partidasJugadas != otro.partidasJugadas) {
            return Integer.compare(this.partidasJugadas, otro.partidasJugadas);
        }

        return 0;
    }

    @Override
    public String toString() {
        return nombre
                + " - " + division
                + " - Partidas: " + partidasJugadas
                + " - Estado: " + estado;
    }
}