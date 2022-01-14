/*4. Escriu un procediment anomenat “Dau” que escrigui per pantalla un enter a
l’atzar que estigui comprès entre 1 i 6.*/

package Practica6;

public class Exercici4 {
    public static void Dau() {
        final int MAX = 6, MIN = 1;
        int numero_aleatori = (int) (Math.random() * (MAX - MIN + 1) + MIN);
        System.out.println(numero_aleatori);
    }
    
    public static void main(String[] args) {
        System.out.println("Dao llanḉat, el número que ha sortit es: ");
        Dau();
    }
}
