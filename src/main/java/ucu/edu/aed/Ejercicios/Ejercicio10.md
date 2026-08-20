La/el Arquitect@ decidió implementar con listas con encadenamiento simple y solicita
desarrollar un algoritmo de alta de un nuevo libro. Requisitos:



• Descripción de alto nivel. Lenguaje natural

• Precondiciones y postcondiciones.

• Seudocódigo detallado.

LN: habiendo verificado que el libro no sea vacio, va a recorrer la lista catalogo para buscar si el libro existe o no,
luego lo inserta al principio de la lista.

PreCondiciones: libro no es nulo. Que exista la lista encadenada Catalogo.
PostCondiciones: la lista catalogo tiene un nuevo elemento Libro, cargado al principio de la lista.Si el libro ya existe, la lista Catalogo no cambia y devuelve false

altaLibro(Libro libro) Boolean {   

    si libro == null entonces
        return False
    fin si

    NuevoNodo = new Nodo(libro)

    NuevoNodo.siguiente = cabeza // esto para no perder el nodo al pasar cabeza al nuevo nodo
    cabeza = NuevoNodo

    return True
}

