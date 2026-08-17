package ucu.edu.aed.Ejercicios;

public class analizadorSintáctico {


    public static void main(String[] args) {
        
        /* PSEUDO
TDAPilaImpl pila = nueva TDAPilaImpl

controlCorchetes(texto): boolean

    para cada caracter del texto hacer

        si caracter = '{' entonces
            pila.mete(caracter)

        sino si caracter = '}' entonces

            si pila.esVacio() entonces
                retornar false
            sino
                pila.saca()
            fin si

        fin si

    fin para

    retornar pila.esVacio()*/

// en este caso me va a entrar una lista de n caractares por eso minimo es de orden (n)
// pero el problema es que cada vez que tengo que meter un elemento en la pila va hasta el final de la lista para poner en el tope
//por lo tanto esto hace que sea de orden (n al cuadrado).
//como peor caso de memoria seria que solo se agreguen caracteres osea que el texto que entra sea algo asi ("{{{{{{{{{{{")

    }

}
