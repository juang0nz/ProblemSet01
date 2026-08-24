package ucu.edu.aed.Ejercicios.Ejercicio26;

import java.util.ArrayList;
import java.util.List;

public class PruebaExpresion {

    public static void main(String[] args) {

        Expresion expresion = new Expresion();
        ExpresionStack expresionStack = new ExpresionStack();

        List<Character> casoCorrecto = new ArrayList<>();
        casoCorrecto.add('{');
        casoCorrecto.add('[');
        casoCorrecto.add(']');
        casoCorrecto.add('}');

        List<Character> casoIncorrecto = new ArrayList<>();
        casoIncorrecto.add('{');
        casoIncorrecto.add('[');
        casoIncorrecto.add('{');
        casoIncorrecto.add('}');
        casoIncorrecto.add(']');

        System.out.println("Expresion:");
        System.out.println("Caso correcto: "
                + expresion.controlCorchetes(casoCorrecto));
        System.out.println("Caso incorrecto: "
                + expresion.controlCorchetes(casoIncorrecto));

        System.out.println();

        System.out.println("ExpresionStack:");
        System.out.println("Caso correcto: "
                + expresionStack.controlCorchetes(casoCorrecto));
        System.out.println("Caso incorrecto: "
                + expresionStack.controlCorchetes(casoIncorrecto));
    }
}