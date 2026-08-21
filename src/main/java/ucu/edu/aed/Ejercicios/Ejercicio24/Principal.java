package ucu.edu.aed.Ejercicios.Ejercicio24;

import ucu.edu.aed.implementaciones.TDAConjuntoImpl;
import ucu.edu.aed.tda.TDAConjunto;

public class Principal {
    public static void main(String[] args) {

        TDAConjunto<TAlumno> aed1 = new TDAConjuntoImpl<>();
        TDAConjunto<TAlumno> pf = new TDAConjuntoImpl<>();

        TAlumno alumno1 = new TAlumno("Juan", "Perez", "1234");
        TAlumno alumno2 = new TAlumno("Maria", "Gomez", "5678");
        TAlumno alumno3 = new TAlumno("Pedro", "Lopez", "9012");
        TAlumno alumno4 = new TAlumno("Ana", "Martinez", "3456");
        TAlumno alumno5 = new TAlumno("Luis", "Rodriguez", "7890");
        TAlumno alumno6 = new TAlumno("Sofia", "Gonzalez", "2345");
        TAlumno alumno7 = new TAlumno("Diego", "Ramirez", "6789");
        TAlumno alumno8 = new TAlumno("Valentina", "Torres", "0123");

        aed1.agregar(alumno1);
        aed1.agregar(alumno2);
        aed1.agregar(alumno3);
        aed1.agregar(alumno4);
        pf.agregar(alumno5);
        pf.agregar(alumno6);
        pf.agregar(alumno7);
        pf.agregar(alumno8);
        pf.agregar(alumno1); // Agregar un alumno que ya está en aed1 para probar la unión
        aed1.agregar(alumno5); // Agregar un alumno que ya está en pf para probar la unión

        // Realizar la unión de los conjuntos aed1 y pf

    TDAConjunto<TAlumno> union = (TDAConjunto<TAlumno>) aed1.union(pf);
    System.out.println("UNION------------------");
    for (int i = 0; i < union.tamanio(); i++) {

        TAlumno alumno = union.obtener(i);

        System.out.println(
            "Alumno: " + alumno.nombre + " "
            + alumno.apellido
            + ", Cédula: " + alumno.cedula
        );
    }
    

    TDAConjunto<TAlumno> interseccion = (TDAConjunto<TAlumno>) pf.interseccion(aed1);
     System.out.println("INTERSECCION------------------");
    for (int i = 0; i < interseccion.tamanio(); i++) {

        TAlumno alumno = interseccion.obtener(i);

        System.out.println(
            "Alumno: " + alumno.nombre + " "
            + alumno.apellido
            + ", Cédula: " + alumno.cedula
        );
    }




    }
}

