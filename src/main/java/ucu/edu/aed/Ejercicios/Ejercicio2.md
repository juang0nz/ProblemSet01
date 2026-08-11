Ejercicio 2 

Analiza el orden del tiempo de ejecución del siguiente algoritmo:

unValor (A, N de tipos enteros) 
i <- 0  // O(1)
Si N < 3 entonces  //O(1)
   devolver (A) // O(1)
fin si 
mientras i < 3 hacer // O(1)
   si arreglo[i] = A entonces  //O(1)
      devolver ((arreglo[0] + arreglo[N-1]) div 2)  // O(1)
   fin si 
   i <- i + 1 // o(1)
fin mientras 
devolver (A div N)  // o(1)
Fin


Este algoritmo es de O(1)