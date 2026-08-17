En nuestro TDA Lista, además de insertar y buscar elementos, eventualmente será necesario retirar un elemento de la misma.
Se podrían definir los siguientes comportamientos:
1. Quitar un elemento de la lista (si existe) y dejarlo disponible para su posterior utilización.
2. Quitar y destruir un elemento (podría llamarse “Eliminar”).
3. Otros comportamientos posibles (a definir).
Consigna
Discutir en el equipo la conveniencia de estos comportamientos y determinar:
•
Qué forma deberían tener (qué parámetros reciben como entrada).
•
Qué valor o resultado deberían devolver.
Implementar el comportamiento acordado (Quitar y/o Eliminar) como método del TDALista construido en el Ejercicio 17, incluyendo casos de prueba en JUnit que cubran: elemento existente, elemento inexistente, y lista vacía.

Sugerencia
Analizar:
•
Qué sucede con el campo Siguiente de un elemento que se ha retirado de la lista.
•
Qué precauciones deberían tomarse para evitar errores o referencias inválidas.



RESPUESTA:


Para el TDA Lista se decidió mantener dos comportamientos distintos para retirar elementos: remover(int index) y remover(T elem).

El método:

T remover(int index);

se utiliza cuando se desea quitar un elemento ubicado en una posición determinada y conservarlo para su posterior utilización. Por ese motivo devuelve el elemento de tipo T que fue retirado. Si el índice recibido no corresponde a una posición válida, se lanza una IndexOutOfBoundsException. Este comportamiento puede interpretarse como una operación de Quitar, ya que el elemento deja de pertenecer a la lista pero sigue disponible para quien invocó el método.

Por otra parte:

boolean remover(T elem);

se utiliza cuando interesa retirar una determinada ocurrencia de un elemento sin necesidad de recuperarlo posteriormente. En este caso el método devuelve true si el elemento fue encontrado y removido, o false si no pertenecía a la lista. Este comportamiento puede considerarse equivalente a una operación de Eliminar.

En una lista simplemente encadenada, retirar un elemento implica modificar las referencias entre los nodos para que el nodo anterior apunte al siguiente del elemento retirado. Por ejemplo:

[A] → [B] → [C]

al retirar B queda:

[A] → [C]

La implementación del TDA no expone los nodos al usuario, sino únicamente los datos de tipo T. Esto evita que desde fuera de la estructura se puedan modificar referencias como siguiente y ayuda a mantener la integridad de la lista.

En Java no es necesario destruir manualmente los objetos retirados, ya que aquellos que dejan de ser alcanzables pueden ser gestionados posteriormente por el recolector de basura. Por este motivo se consideró conveniente distinguir las operaciones principalmente por su valor de retorno y por la intención de uso del elemento retirado.
