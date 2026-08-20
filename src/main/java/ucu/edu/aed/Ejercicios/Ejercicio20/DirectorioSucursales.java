package ucu.edu.aed.Ejercicios.Ejercicio20;

import java.util.LinkedList;

public class DirectorioSucursales {

    final LinkedList<String> sucursales;

    public DirectorioSucursales() {
        this.sucursales = new LinkedList<>();
    }

    /* agregarSucursal() Agregar al final O(1) */
    public void agregarSucursal(String sucursal) {
        sucursales.add(sucursal);
    }

    /* buscarSucursal() Buscar O(n) */
    public boolean buscarSucursal(String sucursal) {
        return sucursales.contains(sucursal);
    }

    /* quitarSucursal() Buscar y quitar O(n) */
    public boolean quitarSucursal(String sucursal) {
        return sucursales.remove(sucursal);
    }

    /*
     * listarSucursales() → O(n²) debido al uso repetido de get(i) sobre una
     * LinkedList.
     */
    public void listarSucursales() {
        for (int i = 0; i < sucursales.size(); i++) {
            System.out.println("Sucursal: " + sucursales.get(i));
        }
    }

    /* cantidadSucursales() Obtener cantidad O(1) */
    public int cantidadSucursales() {
        return sucursales.size();
    }

    /* esVacio() Verificar si esta vacia O(1) */
    public boolean esVacio() {
        return sucursales.isEmpty();
    }
    
    public void listarSucursales(String separador) {

    for (String sucursal : sucursales) {
        System.out.print(sucursal + separador);
    }

    System.out.println();
}

}

/*
 * Sobre memoria, una LinkedList consume más memoria por elemento que un
 * arreglo, porque además del String almacenado
 * cada nodo necesita referencias para enlazarse con otros nodos. En Java
 * LinkedList es doblemente enlazada, así que cada
 * nodo mantiene referencia al anterior y al siguiente. A cambio, crece
 * dinámicamente sin tener que reservar un bloque
 * contiguo ni redimensionar un arreglo.
 */
