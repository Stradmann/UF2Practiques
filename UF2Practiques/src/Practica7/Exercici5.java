/*5. Escriu un procediment anomenat “Titol” que donat un text, el mostri per
pantalla de forma centrada. Pots assumir que la pantalla té un ample de 80
caràcters.*/

package Practica7;

public class Exercici5 {
    public static void main(String[] args){
        titol("La Aventura");
    }
    
    public static void titol(String title){
        
        final int WIDTH = 80;
        String formattedTitle = "";
        for(int i = 0; i < (WIDTH - title.length()) / 2; i++){
            formattedTitle += " ";
        }
        formattedTitle += title;
        System.out.println(formattedTitle);
    }
}
