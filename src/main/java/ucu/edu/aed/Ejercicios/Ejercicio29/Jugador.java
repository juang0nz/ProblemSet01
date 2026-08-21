package ucu.edu.aed.Ejercicios.Ejercicio29;

public class Jugador {

    private Estado estado;
    private String nombre;
    private int partidasJugadas;
    private Division division;


    public Jugador (Estado estado, String nombre, int partidasJugadas, Division division) {
        this.estado = estado;
        this.nombre = nombre;
        this.partidasJugadas = partidasJugadas;
        this.division = division;
    }

    //getters and setters

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas(int partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

}
