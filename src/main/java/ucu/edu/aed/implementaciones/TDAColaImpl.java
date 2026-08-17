package ucu.edu.aed.implementaciones;

import java.util.NoSuchElementException;

import ucu.edu.aed.tda.TDACola;
import ucu.edu.aed.tda.TDALista;

public class TDAColaImpl<T> extends TDAListaImpl<T> implements TDACola<T> {

private TDALista <T> lista;

// sacamos el primer elemento porque en la cola se inserta al final
@Override
public T frente(){
    //me fijo si es vacia
    if (lista.esVacio()) {
    throw new NoSuchElementException();
    }
    //obtengo el del indice 0
    return lista.obtener(0);
}
// agrega al final de la lista
@Override
public boolean  poneEnCola(T dato){
    lista.agregar(dato);
    return true;
}

//quitar de cola, seria remover en este caso
@Override
public T quitaDeCola (){
    //me fijo si es vacia
    if (lista.esVacio()) {
    throw new NoSuchElementException();
    }
    //saco el primero que es el del indice 0
    return lista.remover(0);

}











}