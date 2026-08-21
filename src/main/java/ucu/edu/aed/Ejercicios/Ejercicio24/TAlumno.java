package ucu.edu.aed.Ejercicios.Ejercicio24;


public class TAlumno {
    String nombre;
    String apellido;
    String cedula;

    public TAlumno(String nombre, String apellido, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        //maximo 4 digitos:
        if (cedula.length() > 4) {
            throw new IllegalArgumentException("La cédula no puede tener más de 4 dígitos");
        }
        this.cedula = cedula;
    }
    

}
