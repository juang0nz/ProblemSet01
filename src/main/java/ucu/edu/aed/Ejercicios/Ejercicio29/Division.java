package ucu.edu.aed.Ejercicios.Ejercicio29;
//ES LA FORMA QUE ENCONTRE DE JERARQUIZAR LAS DIVISIONES.
public enum Division {
    BRONCE (1),
    PLATA (2),
    ORO (3),
    PLATINO (4),
    DIAMANTE (5);

    private final int valor;

    Division(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
