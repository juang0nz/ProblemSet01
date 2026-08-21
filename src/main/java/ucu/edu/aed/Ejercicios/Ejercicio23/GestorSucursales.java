package ucu.edu.aed.Ejercicios.Ejercicio23;

import ucu.edu.aed.implementaciones.TDAListaEnlazadaImpl;
import ucu.edu.aed.tda.TDALista;

public class GestorSucursales {

    public TDALista<String> sucursales = new TDAListaEnlazadaImpl<>();

    public void agregarSucursal(String ciudad) {
        if (ciudad != null) {
            sucursales.agregar(ciudad);
        }
    }

    public boolean buscarSucursal(String ciudad) {
        return sucursales.contiene(ciudad);
    }

    public boolean quitarSucursal(String ciudad) {
        return sucursales.remover(ciudad);
    }

    public String imprimir(String separador) {
        String resultado = "";
        for (int i = 0; i < sucursales.tamanio(); i++) {
            resultado = resultado + sucursales.obtener(i) + separador;
        }
        return resultado;
    }

    public int cantidadSucursales() {
        return sucursales.tamanio();
    }

    public boolean estaVacio() {
        return sucursales.esVacio();
    }

    public void cargarDesdeArchivo(String rutaArchivo) throws java.io.FileNotFoundException {
        java.io.File archivo = new java.io.File(rutaArchivo);
        java.util.Scanner sc = new java.util.Scanner(archivo);

        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            linea = linea.trim();
            if (!linea.isEmpty()) {
                agregarSucursal(linea);
            }
        }
        sc.close();
    }
}
