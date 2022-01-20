/*6. Implementa un programa que faci servir un tipus de dada anomenat “Pila”.
Una pila és un tipus de dada on es van afegint valors i es van traient en l’ordre
invers al qual s’han afegit, també conegut com LIFO (Last In First Out). El
programa ha de presentar el següent menú d’opcions:
1.- Afegir número (push)
2.- Treure número (pop)
3.- Mostrar contingut de la pila
4.- Sortir
La pila admet com a màxim 10 valors. Si intentem afegir un onzè element el
sistema no ho ha de permetre i ha d’avisar a l’usuari que la pila es troba plena.
De la mateixa manera, si intentem treure un número d’una pila que es troba
buida, també s’ha d’informar a l’usuari que no pot fer aquesta operació.
Al treure un número de la pila, s’ha de mostrar per pantalla quin és el número
que s’ha tret.
El programa s’ha d’implementar amb un array. No es poden fer servir els tipus
de dades de les llibreries de Java.*/
package Practica7;

import java.util.Scanner;
import handy.Validator;

public class Exercici6 {

    static Scanner scan = new Scanner(System.in);

    static final int DIM = 10;

    static class Pila {

        static int v[] = new int[DIM];
        static int i = 0;
        static boolean posNull = true;
    }

    static void mostraMenu() {
        System.out.println("1. Afegir número (push)");
        System.out.println("2. Treure número (pop)");
        System.out.println("3. Mostrar contingut de la pila");
        System.out.println("4. Sortir");
    }

    static void push() {
        if (Pila.i < 10) {
            Pila.v[Pila.i] = handy.Validator.readInt("Introdueix el valor: ");
            Pila.i++;
        } else {
            System.out.println("Error: espai no disponible");
        }
        if (Pila.i == 0) {
            Pila.posNull = true;
        }
    }

    static void pop() {
        int num = 0;
        if (Pila.i == 0 && Pila.posNull) {
            Pila.v = new int[DIM];
            Pila.i = 0;
            Pila.posNull = false;
        }
        if (Pila.posNull) {
            num = handy.Validator.readInt("Introdueix el valor per treure: ");
            Pila.i--;
        } else {
            System.out.println("Error: pila buida, no es pot treure cap valor.");
        }
    }

    static void mostraPila() {
        for (int i = Pila.i - 1; i >= 0; i--) {
            System.out.print(Pila.v[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        boolean sortir = false;
        do {
            mostraMenu();
            int opcio = handy.Validator.readInt("Inrodueix la teva opcio: ");
            switch (opcio) {
                case 1:
                    push();
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    mostraPila();
                    break;
                case 4:
                    sortir = true;
                    System.out.println("Programa finalitzat");
                    break;
            }
        } while (sortir != true);
        scan.close();
    }
}
