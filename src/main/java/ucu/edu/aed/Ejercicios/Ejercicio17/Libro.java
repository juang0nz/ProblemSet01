package ucu.edu.aed.Ejercicios.Ejercicio17;

public class Libro {
String titulo;
String codigo;
double precio;
int stock;


public Libro (String titulo, String codigo, double precio, int stock) {
    this.titulo = titulo;
    this.codigo = codigo;
    this.precio = precio;
    this.stock = stock;

}


public void setPrecio(double precio) {
    this.precio = precio;
}


public void setStock(int stock) {
    this.stock = stock;
}


public String getTitulo() {
    return titulo;
}


public String getCodigo() {
    return codigo;
}


public double getPrecio() {
    return precio;
}


public int getStock() {
    return stock;
}






}