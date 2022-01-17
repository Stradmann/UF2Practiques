/*3. Escriu una funció anomenada “Roman” al que se li passa un número enter
entre 1 i 3999 i retorni el seu valor en números romans*/

/*
    I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000
*/
package Practica7;

public class Exercici3 {
    public static void main(String[] args){
        int number = handy.Validator.readInt("Introdueix un numero enter inferior a 4000", 1, 3999);
        String romanNumber = toRoman(number);
        System.out.println(romanNumber);
    }
    
    public static String toRoman(int n){
        
        String result = "";
        String decimalString = String.valueOf(n);
        int[] decFactor = new int[decimalString.length()];
        
        int aux = n;
        for(int i = 0; i < decFactor.length; i++){
            int multi = aux % 10;
            decFactor[i] = multi * (int)Math.pow(10, i);
            aux = (aux - multi) / 10;    
        }
        for(int i = decFactor.length -1; i >= 0; i--){
            result += individualRomanNumbers(decFactor[i]);
        }
        return result;
    }
    
    public static String individualRomanNumbers(int number){
        
        String result = "";
        switch(number){
            case 1:
                result = "I";
                break;
            case 2:
                result = "II";
                break;
            case 3:
                result = "III";
                break;
            case 4:
                result = "IV";
                break;
            case 5:
                result = "V";
                break;
            case 6:
                result = "VI";
                break;
            case 7:
                result = "VII";
                break;
            case 8:
                result = "VIII";
                break;
            case 9:
                result = "IX";
                break;
            case 10:
                result = "X";
                break;
            case 20:
                result = "XX";
                break;
            case 30:
                result = "XXX";
                break;
            case 40:
                result = "XL";
                break;
            case 50:
                result = "L";
                break;
            case 60:
                result = "LX";
                break;
            case 70:
                result = "LXX";
                break;
            case 80:
                result = "LXXX";
                break;
            case 90:
                result = "XC";
                break;
            case 100:
                result = "C";
                break;
            case 200:
                result = "CC";
                break;
            case 300:
                result = "CCC";
                break;
            case 400:
                result = "CD";
                break;
            case 500:
                result = "D";
                break;
            case 600:
                result = "DC";
                break;
            case 700:
                result = "DCC";
                break;
            case 800:
                result = "DCCC";
                break;
            case 900:
                result = "CM";
                break;
            case 1000:
                result = "M";
                break;
            case 2000:
                result = "MM";
                break;
            case 3000:
                result = "MMM";
                break;
        }
        
        return result;
    }
}
