package ucu.edu.aed.Ejercicios.Ejercicio26;

import java.util.List;
import java.util.Stack;

public class ExpresionStack {

    public boolean controlCorchetes(List<Character> expresion) {

        if (expresion == null) {
            throw new IllegalArgumentException("La expresión no puede ser nula");
        }

        Stack<Character> pila = new Stack<>();

        for (Character caracter : expresion) {

            if (caracter == '{' || caracter == '[') {
                pila.push(caracter);

            } else if (caracter == '}' || caracter == ']') {

                if (pila.empty()) {
                    return false;
                }

                Character apertura = pila.pop();

                if (caracter == '}' && apertura != '{') {
                    return false;
                }

                if (caracter == ']' && apertura != '[') {
                    return false;
                }
            }
        }

        return pila.empty();
    }
}