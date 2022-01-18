/*4. Escriu una funció anomenada “ValidarSuperusuari” que demani un password
i que el comprovi amb un text emmagatzemat en una constant interna. Si no
coincideix l’ha de tornar a demanar un màxim de 3 vegades. La funció ha de
tornar si l’usuari ha encertat o no el password.*/
package Practica7;

import java.util.Scanner;

public class Exercici4 {

    public static boolean ValidarSuperusuari(String password) {
        boolean valid = true;
        final String PASSWORD_CORRECTE = "Programacio";
        if (!password.equals(PASSWORD_CORRECTE)) {
            valid = false;
        }
        return valid;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int MAX_INTENTS = 3;
        final int MIN_INTENTS = 0;
        int intents = MAX_INTENTS;
        boolean correcte = false;
        System.out.print("Estas intentant entrar a l'usuari Superusuari, quina es la contrasenya? ");
        do {
            if (intents <= 2) {
                System.out.println("Et queden " + intents + " intents.");
            }
            String password = scan.nextLine();
            correcte = ValidarSuperusuari(password);
            intents--;
        } while ((intents > MIN_INTENTS) && (!correcte));
        if (correcte) {
            System.out.println("Entrant...");
        } else {
            System.out.println("No et queden més intents. Torna ha intentar-ho en 30 segons.");
        }
    }
}
