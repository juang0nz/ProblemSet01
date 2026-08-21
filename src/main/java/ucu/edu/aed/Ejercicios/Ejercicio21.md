Los nodos de una lista simplemente encadenada tienen dos atributos:

• DATOS: de tipo dato.
• SIGUIENTE: de tipo nodo de lista, que hace referencia al siguiente nodo.

Problema 1

Sean nodo1, nodo2 y nodo3 tres nodos consecutivos (nodo2 sigue a nodo1, nodo3
sigue a nodo2), y el siguiente fragmento de código:

Nuevo nodo otroNodo

otroNodo.siguiente <- nodo1
nodo2.siguiente <- nodo3



4. No tiene efecto. // porque se diria que se inserta antes del nodo 1 pero para insertarse en la lista 
deberia tambien asignarse como primero.

Problema 2

NuevoNodo otroNodo
otroNodo <- nodo1.siguiente
nodo1.siguiente <- nodo3

Opciones:

3. Elimina nodo2.


Problema 3

NuevoNodo otroNodo
otroNodo.siguiente <- nodo1.siguiente
nodo1.siguiente <- otroNodo

Opciones:

2. Inserta otroNodo entre nodo1 y nodo2.

Problema 4

NuevoNodo otroNodo
NuevoNodo nodoActual
nodoActual <- primero

mientras nodoActual <> nulo hacer
nodoActual <- nodoActual.siguiente
fin mientras

nodoActual.siguiente <- otroNodo

Opciones:

4. Siempre error. // porque termina nodo actual siendo null, como es null sale del mientras y ahi hace null.siguiente, que da error y si es vacio tambien.

Problema 5

Nuevo nodo otroNodo
Nuevo nodo nodoActual

nodoActual <- primero

mientras nodoActual.siguiente <> nulo hacer
nodoActual <- nodoActual.siguiente
fin mientras

nodoActual.siguiente <- otroNodo

Opciones:

1. Inserta otroNodo como último nodo. // ahi si lo inserta porque se posiciona en el anterior
