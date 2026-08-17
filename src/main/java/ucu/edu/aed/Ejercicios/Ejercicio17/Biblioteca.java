package ucu.edu.aed.Ejercicios.Ejercicio17;

import ucu.edu.aed.implementaciones.TDAListaEnlazadaImpl;
import ucu.edu.aed.tda.TDALista;

public class Biblioteca {

    public TDAListaEnlazadaImpl<Libro> catalogo = new TDAListaEnlazadaImpl<Libro>();

    // agrega un libro a catalogo

    public void agregarLibro(Libro libro) {
        catalogo.agregar(libro);
    }

    public void agregarEjemplares(String codigo, int cantidad) {
        for (int i = 0; i < catalogo.tamanio(); i++) {
            Libro libro = catalogo.obtener(i);
            if (libro.getCodigo().equals(codigo)) {
                libro.setStock(libro.getStock() + cantidad);
                break;
            }

        }
    }

    public void prestarLibro(String codigo) {
        for (int i = 0; i < catalogo.tamanio(); i++) {
            Libro libro = catalogo.obtener(i);
            if (libro.getCodigo().equals(codigo)) {
                // me fijo antes de restar si el stock ya no es cero
                if (libro.getStock() > 0) {
                    libro.setStock(libro.getStock() - 1);
                }
            }
        }
    }

    public void devolverLibro(String codigo) {
        for (int i = 0; i < catalogo.tamanio(); i++) {
            Libro libro = catalogo.obtener(i);
            if (libro.getCodigo().equals(codigo)) {
                libro.setStock(libro.getStock() + 1);

            }
        }
    }

    public void retirarLibro(String codigo) {
        for (int i = 0; i < catalogo.tamanio(); i++) {
            Libro libro = catalogo.obtener(i);
            if (libro.getCodigo().equals(codigo)) {
                catalogo.remover(libro);
                break;
            }
        }
    }

    public int consultarExistencias(String codigo) {
        for (int i = 0; i < catalogo.tamanio(); i++) {
            Libro libro = catalogo.obtener(i);
            if (libro.getCodigo().equals(codigo)) {
                return libro.getStock();
            }
        }
        return 0;
    }

    public TDALista<Libro> listarPorTitulo() {
        return catalogo.ordenar((libro1, libro2) -> libro1.getTitulo().compareTo(libro2.getTitulo()));
    }

    // el trabajo en subgrupos para el subgrupo A es registrar compra o donación de
    // ejemplares, o alta de un libro nuevo, e indicar el valor total agregado al
    // stock. Formato del archivo adquisiciones.txt: CODIGO_LIBRO, TITULO_LIBRO,
    // PRECIO_REPOSICION, CANTIDAD

    public double registrarAdquisicion(String codigo,String titulo,double precio,int cantidad) {

        Libro libro = catalogo.buscar(l -> l.getCodigo().equals(codigo));

        if (libro == null) {
            libro = new Libro(titulo, codigo, precio, cantidad);
            catalogo.agregar(libro);
        } else {
            libro.setStock(libro.getStock() + cantidad);
        }

        return precio * cantidad;
    }


/*Sub-equipo B – Préstamos: Registrar préstamos (reducen stock) y devoluciones (aumentan stock) e indicar la variación total de 
ejemplares prestados. Formato del archivo prestamos.txt: CODIGO_LIBRO, TIPO, CANTIDAD donde TIPO es PRESTAMO o DEVOLUCION. Nota: 
si la cantidad solicitada en un préstamo excede el stock, se presta hasta donde alcance. */



    public int registrarMovimiento(String codigo, String tipo, int cantidad) {

        Libro libro = catalogo.buscar( l -> l.getCodigo().equals(codigo));

        if (libro == null) {
            return 0;
        }

        if (tipo.equals("PRESTAMO")) {

            int cantidadPrestada = Math.min(cantidad, libro.getStock());

            libro.setStock(libro.getStock() - cantidadPrestada);

            return cantidadPrestada;
        }

        if (tipo.equals("DEVOLUCION")) {

            libro.setStock(libro.getStock() + cantidad);

            return -cantidad;
        }

        return 0;
    }

}
