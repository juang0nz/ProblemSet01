La Biblioteca Central UCU necesita gestionar su catálogo de libros y nos encarga
construir un sistema eficiente. Por cada libro se almacenará:
• Título del libro (máx. 30 caracteres).
• Código de identificación (ISBN o código interno, máx. 20 caracteres).
Precio de reposición.
La primera versión del sistema deberá implementar:
• Incorporar un nuevo libro al catálogo.
• Agregar ejemplares (stock) a un libro existente.
• Reducir ejemplares (stock) de un libro existente (préstamo o baja).
• Listar todos los libros ordenados por título, mostrando además su stock.
Las listas pueden implementarse con arrays o listas encadenadas. Analizar:

1. Costo de memoria en cada caso.
2. Consideraciones sobre la cantidad de libros soportada.
3. Consideraciones de eficiencia para cada operación según la implementación.

Elegimos una lista enlazada porque no sabemos la cantidad de libros que vamos a recibir 
a diferencia con el array si nos sobrepasamos con la cantidad de los elementos del array no vamos a tener que re dimensionarlo 

