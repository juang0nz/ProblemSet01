Analiza el orden de tiempo de ejecución del siguiente algoritmo:



function particion(i, j: integer; pivote: integer): integer;
/* Divide V[i], .., V[j] para que las claves menores que pivote estén
a la izquierda y las mayores o iguales a la derecha.
Devuelve el lugar donde se inicia el grupo de la derecha.
*/



COMIENZO
L <- i;
R <- j;
Repetir
intercambia(V[L], V[R]);
mientras V[L] < pivote hacer L := L + 1; fin mientras
mientras V[R] >= pivote hacer R := R - 1; fin mientras
Hasta que L > R
Devolver L;
FIN

Este algoritmo es de O(n) ya que tiene dos mientras que son de orden (n) pero actuan por separado, O(n)+O(n)=O(n)