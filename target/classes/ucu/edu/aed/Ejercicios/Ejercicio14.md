Dado el siguiente fragmento de código y los nodo “otroNodo” y “nodoActual”:


nodoActual <-primero

`mientras nodoActual <> nulo hacer`

    nodoActual =nodoActual.siguiente

`fin mientras`

nodoActual.siguiente =otroNodo



¿Qué opción es correcta? 

1.Inserta otroNodo como último nodo.

2.Inserta otroNodo como primer nodo.

3.Error si la lista está vacía.

4.Siempre error.


Da error porque no se puede hacer nulo.siguiente 

Inserta otroNodo como ultimo nodo,deberia tener un mientras como "mientras nodoActual.siguiente <> nulo hacer"
