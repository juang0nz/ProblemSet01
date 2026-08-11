Analiza el orden de tiempo de ejecución del siguiente algoritmo:


Desde i = 1 hasta N-1 hacer
    Desde j = N hasta i+1 hacer
        Si arreglo[j] < arreglo[j-1] entonces
            Intercambia(arreglo[j], arreglo[j-1])
        FinSi
    FinDesde
FinDesde

1. Analiza el orden de complejidad temporal:
a) mejor caso : que el arreglo ya este ordenado. O(ncuadrado)
b) peor caso : que este invertido. O(ncuadrado)


2. Justifica el resultado.

en ambos casos se ejecutan los bucles anidados por lo tantos es de O(ncuadrado) igual.