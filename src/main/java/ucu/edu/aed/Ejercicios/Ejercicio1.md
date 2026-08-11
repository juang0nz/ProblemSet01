Ejercicio 1


Analiza el orden del tiempo de ejecución de los siguientes algoritmos


a) Este es de O(n)

public static int enRango (int[] a, int bajo, int alto) { // O(1)

int contador = 0       // O(1)

for (int i = 0; i < a.length; i++) { // O(n)

if (a[i] >= bajo && a[i] < alto  

contador++;  

return contador;
}




b) lo que determina que sea O (log2n) es el i * 2

unaFuncion(N de tipo entero)
i <- 1
j <- N
mientras i < N hacer
j <- N - 1
i <- i * 2
fin mientras
devolver (j)
fin




c) es de O (N) POR EL NOTAS en el metodo enRango ESE QUE ES N O(1)*O(n) = O(n)

int[] cuentas = new int[100]; O(1)
for (int i = 0; i < 100; i++) {
 
   cuentas[i] = enRango(notas , i, i+1);