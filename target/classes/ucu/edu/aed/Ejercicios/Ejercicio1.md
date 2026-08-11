Ejercicio 1


Analiza el orden del tiempo de ejecución de los siguientes algoritmos


a) // O(1)

public static int enRango (int[] a, int bajo, int alto) { // O(1)
int contador = 0       // O(1)

for (int i = 0; i < a.length; i++) { // O(1)

if (a[i] >= bajo && a[i] < alto  // O(1)

contador++;   // O(1)

return contador;
}




b)

unaFuncion(N de tipo entero)
i <- 1
j <- N
mientras i < N hacer
j <- N - 1
i <- i * 2
fin mientras
devolver (j)
fin




c)

int[] cuentas = new int[100];
for (int i = 0; i < 100; i++) {
 
   
 
   cuentas[i] = enRango(notas , i, i+1);