/*3. Hem descobert vida intel·ligent a Mart i hem vist que allà només coneixen les
taules de multiplicar de l’1 i del 2, però saben que multiplicar dos números és
equivalent a:
𝒙 ∗ 𝒚 = {
( 𝟐 ∗ 𝒙) ∗ (𝒚 𝒅𝒊𝒗 𝟐), 𝒔𝒊 𝒚 é𝒔 𝒑𝒂𝒓𝒆𝒍𝒍
( 𝟐 ∗ 𝒙) ∗ (𝒚 𝒅𝒊𝒗 𝟐) + 𝒙, 𝒔𝒊 𝒚 é𝒔 𝒔𝒆𝒏𝒂𝒓
NOTA: div significa “divisió entera” (retorna la part entera de la divisió)
Per altra banda, amb el llenguatge Java tenim els operadors de desplaçament
de bits que poden servir per multiplicar o dividir per 2 un número enter.
Exemple: per multiplicar per 2, desplacem a l’esquerra 1 bit:
4 << 1 = 8 ➔ 100 << 1 ➔ 1000 = 8
 I per dividir entre dos, desplacem a la dreta un bit:
4 >> 1 = 2 ➔ 100 >> 1 ➔ 10 = 2
Sabent tot això, has d’implementar un algorisme recursiu que multipliqui dos
números sense fer servir els operadors aritmètics de multiplicació ni de divisió
ni de mòdul. L’algorisme multiplicar(a,b) no pot consistir en sumar el número
a un total de b vegades*/

package Practica9;

public class Exercici3 {
    public static void main(String[] args){
        System.out.println(marsMultiplication(2,2));
    }
    
    public static int marsMultiplication(int x, int y){
        
        int result;
        if(y >> 1 == 0){
            result =  x;
        }else if (y % 2 == 0){
            result = marsMultiplication(x << 1, y >> 1);
        }else{
            result = marsMultiplication(x << 1, y >> 1) + x;
        }
        
        return result;
    }
}
