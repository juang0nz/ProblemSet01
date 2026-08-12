 A) ¿Qué hace el siguiente código?
public void myFunction(int i) {
Nodo nodo = new Nodo(i, this.primero);
this.primero = nodo;
}

c. Agregar un nodo al principio de la lista.

B) En una lista circular, el siguiente fragmento de código Java:
actual = this.primero;
while (actual.siguiente != null)
actual = actual.siguiente;
actual.siguiente = otroNodo;
otroNodo.siguiente = null;

d. Aunque actual no sea null al inicio, ejecuta indefinidamente.

C) En una lista enlazada simple, el siguiente fragmento de código Java:
temporal.siguiente = actual.siguiente;
actual.siguiente = temporal;

d. Inserta el nodo temporal a continuación del nodo actual.

D) En una lista enlazada simple, el siguiente fragmento de código Java:
temporal = actual.siguiente;
actual.siguiente = temporal.siguiente;

a. Elimina de la lista al nodo temporal.