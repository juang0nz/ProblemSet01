Analiza el orden de tiempo de ejecución del siguiente algoritmo:


miFunción
    Desde i = 1 hasta N-1 hacer O(n)
        Desde j = N hasta i+1 hacer O(n)

            Si arreglo[j] < arreglo[j-1] entonces
                Intercambia(arreglo[j], arreglo[j-1])

            Fin si
        Fin desde
    Fin desde
Fin


en este caso hay dos bucles anidados de O(n) por lo tanto es O(n)*O(n)=O(ncuadrado)