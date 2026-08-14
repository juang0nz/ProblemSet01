Ejercicio 12

Dado el siguiente fragmento de código:

otroNodo <-nodo1.siguiente

nodo1.siguiente <-nodo3

Opciones:

1.Inserta otroNodo antes de nodo1.

2.Inserta otroNodo entre nodo1 y nodo2.

3.Elimina nodo2.

4.No tiene efecto



    ┌───────── nodo1.siguiente
             			  │
            			  ▼
┌───────┐   ┌───────┐   ┌───────┐
│ nodo1 │──►│ nodo2 │──►│ nodo3 │──► null
└───────┘   └───────┘   └───────┘
             			 ▲
            		         │
          			otroNodo-----------> otroNodo = nodo2

**Elimina nodo2** entendiendo “elimina” como que lo  **saca de la cadena que parte de `nodo1`** .
