package ucu.edu.aed.Ejercicios;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;

import ucu.edu.aed.Ejercicios.Ejercicio17.Biblioteca;
import ucu.edu.aed.Ejercicios.Ejercicio17.Libro;
import ucu.edu.aed.Ejercicios.Ejercicio20.DirectorioSucursales;
import ucu.edu.aed.implementaciones.TDAListaEnlazadaImpl;

public class Main {
    public static void main(String[] args) {
        /*-------------------------------------------------------------------------------------------------------------------------------- */
        // EJERCICIO 17
// Incorporar un nuevo libro al catálogo.
        Biblioteca biblioteca = new Biblioteca();
        Libro libro1 = new Libro("El Principito", "001", 15.99, 10);
        Libro libro2 = new Libro("Cien Años de Soledad", "002", 20.50, 5);
        Libro libro3 = new Libro("1984", "003", 12.75, 8);

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);

//Agregar ejemplares a un libro existente.
        biblioteca.agregarEjemplares("001", 5); // Agregar 5 ejemplares al libro1
    
//Registrar préstamo o devolución de un libro.
        biblioteca.prestarLibro("002"); // Registrar préstamo de un ejemplar del libro2
        biblioteca.devolverLibro("003"); // Registrar devolución de un ejemplar del libro3

//Retirar del catálogo libros que ya no circulan.
        biblioteca.retirarLibro("001"); // Retirar el libro1 del catálogo
//Consultar la cantidad de ejemplares disponibles de un libro.
        int existenciasLibro2 = biblioteca.consultarExistencias("002");
        System.out.println("Existencias del libro 002: " + existenciasLibro2);
//Listar todos los libros, ordenados por título, con su stock
        System.out.println("Libros ordenados por título:");
        TDAListaEnlazadaImpl<Libro> ordenado = new TDAListaEnlazadaImpl<>();
        ordenado = (TDAListaEnlazadaImpl<Libro>) biblioteca.listarPorTitulo();
        for (int i = 0; i < ordenado.tamanio(); i++) {
            Libro libro = ordenado.obtener(i);
            System.out.println("Título: " + libro.getTitulo() + ", Código: " + libro.getCodigo() + ", Precio: " + libro.getPrecio() + ", Stock: " + libro.getStock());
        }
/*Sub-equipo A – Adquisiciones: Registrar compra o donación de ejemplares, o alta de un libro nuevo, e indicar el valor total agregado al stock.
Formato del archivo adquisiciones.txt:
CODIGO_LIBRO, TITULO_LIBRO, PRECIO_REPOSICION, CANTIDAd*/

// Biblioteca biblioteca = new Biblioteca();

try {

    Scanner scanner = new Scanner(new File("src/main/resources/adquisiciones.txt"));

    double valorTotal = 0;

    while (scanner.hasNextLine()) {
        String linea = scanner.nextLine();

        String[] datos = linea.split(",");

        String codigo = datos[0].trim();
        String titulo = datos[1].trim();
        double precio = Double.parseDouble(datos[2].trim());
        int cantidad = Integer.parseInt(datos[3].trim());

        valorTotal += biblioteca.registrarAdquisicion(
                codigo,
                titulo,
                precio,
                cantidad
        );
    }

    scanner.close();

    System.out.println("Valor total agregado: " + valorTotal);

} catch (FileNotFoundException e) {
    System.out.println("No se encontró el archivo adquisiciones.txt");
}
/*Sub-equipo B – Préstamos: Registrar préstamos (reducen stock) y devoluciones (aumentan stock) e indicar la variación total de ejemplares prestados.
Formato del archivo prestamos.txt:
CODIGO_LIBRO, TIPO, CANTIDAD
donde TIPO es PRESTAMO o DEVOLUCION.
Nota: si la cantidad solicitada en un préstamo excede el stock, se presta hasta donde alcance. */

try {

    Scanner scanner = new Scanner(
        new File("src/main/resources/prestamos.txt")
    );

    int variacionTotal = 0;

    while (scanner.hasNextLine()) {

        String linea = scanner.nextLine();
        String[] datos = linea.split(",");

        String codigo = datos[0].trim();
        String tipo = datos[1].trim();
        int cantidad = Integer.parseInt(datos[2].trim());

        variacionTotal += biblioteca.registrarMovimiento(
                codigo,
                tipo,
                cantidad
        );
    }

    scanner.close();

    System.out.println(
        "Variación total de ejemplares prestados: " + variacionTotal
    );

} catch (FileNotFoundException e) {
    System.out.println("No se encontró prestamos.txt");
}

 /*-------------------------------------------------------------------------------------------------------------------------------- */

            //EJERCICIO 20

DirectorioSucursales sucursales = new DirectorioSucursales();

try {

    Scanner scanner = new Scanner(
        new File("src/main/resources/sucursales.txt")
    );

    while (scanner.hasNextLine()) {
        String sucursal  = scanner.nextLine();
        sucursales.agregarSucursal(sucursal);
    }
    scanner.close();
} catch (FileNotFoundException e) {
    System.out.println("No se encontró sucursales.txt");
}
//sucursales.listarSucursales();
//System.out.println("Cantidad de sucursales: " + sucursales.cantidadSucursales());
// da 107 la respuesta d.
//sucursales.quitarSucursal("Chicago");
//sucursales.listarSucursales();
//sucursales.agregarSucursal("Hong Kong"); // la que le sigue es Shenzhen
//sucursales.listarSucursales();
//sucursales.quitarSucursal("Shenzhen");
//sucursales.quitarSucursal("Tokio");
//sucursales.listarSucursales(); //d) Ninguna de las anteriores, no muestra nada
sucursales.listarSucursales(";"); // lo implemente nuevo para que quede como pedia la letra








/*-------------------------------------------------------------------------------------------------------------------------------- */








    }
}