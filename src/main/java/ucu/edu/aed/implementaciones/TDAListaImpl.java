package ucu.edu.aed.implementaciones;

import java.util.Comparator;
import java.util.function.Predicate;

import ucu.edu.aed.tda.TDALista;

public class TDAListaImpl<T> implements TDALista<T> {

    private Nodo<T> primero;
    private int tamanio;

    // Implementación del método agregar al final de la lista:
    @Override
    public void agregar(T elem) {
        // si la lista es vacia:
        Nodo<T> nuevoNodo = new Nodo<>(elem);
        if (primero == null) {
            primero = nuevoNodo;
        } else { // sino al pri9mero le digo actual y recorro los siguientes hasta encontrar el
                 // ultimo y ahi seteo el nuevoNodo
            Nodo<T> actual = primero;

            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        tamanio++;

    }

    // agregar un elemento en un indice especifico:
    @Override
    public void agregar(int index, T elem) {

        if (index < 0 || index > tamanio) {
            throw new IndexOutOfBoundsException();
        }

        Nodo<T> nuevoNodo = new Nodo<>(elem);
        // si el indice es 0 ahi lo pongo en el primero
        if (index == 0) {
            nuevoNodo.setSiguiente(primero); // primero hago esto sino pierdo el nodo
            primero = nuevoNodo;
        } else {
            // en caso de que sea un numero aceptable dentro del tamanio, y no sea el
            // primero recorro hasta el anterior al indice y
            Nodo<T> actual = primero;
            int i = 0;
            while (i < index - 1) {
                actual = actual.getSiguiente();
                i++;
            }

            nuevoNodo.setSiguiente(actual.getSiguiente()); // pone el nuevo nodo apuntando al mismo que apunta
                                                           // actual.siguiente
            actual.setSiguiente(nuevoNodo); // y despues pone a actual a apuntar a nuevoNodo asi lo pone en medio.
        }

        tamanio++;
    }

    @Override
    public T obtener(int index) {

        // verifico que este dentro el indice
        if (index < 0 || index >= tamanio) {
            throw new IndexOutOfBoundsException();
        }
        Nodo<T> actual = primero;
        int i = 0;
        // avanza hasta el numero del index -1 sirve si empieza en 0
        while (i < index) {
            actual = actual.getSiguiente();
            i++;
        }
        // retorna el dato que quedo en actual
        return actual.getDato();
    }

    // removemos un dato y devolvemos segun el indice que nos pasan

    @Override
    public T remover(int index) {

        // verifico que este dentro el indice
        if (index < 0 || index >= tamanio) {
            throw new IndexOutOfBoundsException();
        }
        // si es el primero
        if (index == 0) {
            T dato = primero.getDato(); // obtengo dato
            primero = primero.getSiguiente(); // pongo como primero el que le seguia si esta
            tamanio--; // disminuyo tamanio
            return dato; // retorno el dato
        }
        Nodo<T> actual = primero;
        int i = 0;
        while (i < index - 1) {
            actual = actual.getSiguiente();
            i++;
        }
        T dato = actual.getSiguiente().getDato(); // guardo dato a eliminar, al siguiente donde me quede
        actual.setSiguiente(actual.getSiguiente().getSiguiente());
        tamanio--;
        return dato;
    }

    @Override
    public boolean remover(T elem) {
        // si la lista es vacia retorna false de una
        if (primero == null) {
            return false;
        }
        // en caso de que sea el primero:
        if (primero.getDato().equals(elem)) {
            primero = primero.getSiguiente();
            tamanio--;
            return true;
        }
        // en caso de que toque recorrer la lista para ver si esta el elemento:
        Nodo<T> actual = primero;

        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getDato().equals(elem)) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente()); // estando parado en el anterior, muevo el
                                                                           // puntero para el de adelante asi elimino a
                                                                           // un nodo.
                tamanio--;
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    // verifico si contiene el elemento que necesito en la lista
    @Override
    public boolean contiene(T elem) {
        Nodo<T> actual = primero;
        while (actual != null) {
            if (actual.getDato().equals(elem)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    // aca lo que hacemos es recorrer la lista y si esta el elem se devuelve el
    // indice, sino -1
    @Override
    public int indiceDe(T elem) {
        int i = 0;
        Nodo<T> actual = primero;
        while (actual != null) {
            if (actual.getDato().equals(elem)) {
                return i;
            }
            i++;
            actual = actual.getSiguiente();
        }
        return -1;
    }

    // para buscar con un cierto criterio
    /*
     * Libro encontrado = lista.buscar(
     * libro -> libro.getTitulo().equals("Dune")
     * );
     */
    @Override
    public T buscar(Predicate<T> criterio) {

        Nodo<T> actual = primero;
        while (actual != null) {
            if (criterio.test(actual.getDato())) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public TDALista<T> ordenar(Comparator<T> comparator) {
        // creo la lista que tengo que devolver luego
        TDAListaImpl<T> lista = new TDAListaImpl<>();

        Nodo<T> actual = primero;
        while (actual != null) {

            T dato = actual.getDato();
            int posicion = 0;
            // si cumple la comparacion en el dato, guarda posicion y dato para agragar en
            // la lista nueva
            while (posicion < lista.tamanio && comparator.compare(lista.obtener(posicion), dato) <= 0) {
                posicion++;
            }

            lista.agregar(posicion, dato);
            actual = actual.getSiguiente();
        }
        return lista;
    }
/*
    @Override
    public int tamanio() {
        // si la lista es vacia retorna false de una
        if (primero == null) {
            return 0;
        }
        Nodo<T> actual = primero;
        int contador = 1;
        while (actual.getSiguiente() != null){
            contador++;
            actual = actual.getSiguiente();
        }

        return contador;
    }*/
// otra forma usando el atributo tamanio
    @Override
    public int tamanio(){
        return tamanio;
    }

// verifica si la lista es vacia
    @Override
    public boolean esVacio(){
// si la lista es vacia retorna true de una
        if (primero == null) {
            return true;
    }
    return false;
    }
//para vaciar una lista, java permite apuntar el primero a null y luego actualizo el tamanio
@Override
public void vaciar (){
    primero = null;
    tamanio = 0;
}

}
