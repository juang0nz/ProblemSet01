Analiza el orden del tiempo de ejecución del siguiente algoritmo :

otraFunción(claveAbuscar) 
inicio <- 0  O(1)
fin <- N - 1  0(1)

mientras inicio <= fin hacer  O(log n)

   medio <- (inicio + fin) div 2

   si (arreglo[medio] < claveAbuscar) entonces 
      inicio <- medio + 1 
   sino 
      si (arreglo[medio] > claveAbuscar) entonces 
         fin <- medio - 1 
      Sino 
          devolver medio 
      fin si 
   fin si 
fin mientras 
devolver -1 
fin


Este algoritmo es de O (log n) porque el "incremento es reducirse a la mitad"