package ucu.edu.aed.Ejercicios.Ejercicio26;

import java.util.List;

import ucu.edu.aed.tda.TDAPila;
import ucu.edu.aed.implementaciones.TDAPilaImpl;

public class ExpresionStack {

    public boolean controlCorchetes(List<Character> expresion) {

        if (expresion == null) {
            throw new IllegalArgumentException("La expresión no puede ser nula");
        }

        TDAPila<Character> pila = new TDAPilaImpl<>();

        for (Character caracter : expresion) {

            if (caracter == '{' || caracter == '[') {
                pila.mete(caracter);

            } else if (caracter == '}' || caracter == ']') {

                if (pila.esVacio()) {
                    return false;
                }

                Character apertura = pila.saca();

                if (caracter == '}' && apertura != '{') {
                    return false;
                }

                if (caracter == ']' && apertura != '[') {
                    return false;
                }
            }
        }

        return pila.esVacio();
    }
}