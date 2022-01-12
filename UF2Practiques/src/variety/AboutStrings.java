
package variety;

public class AboutStrings {
    
    public static void printReverseString(String msg){
        
        for(int i = msg.length() - 1; i >= 0; i--){
            System.out.print(msg.charAt(i));
        }
    }
    
    public static String initials(String msg){
        
        String result = "";
        String[] words;
        msg = msg.toUpperCase();
        words = msg.split(" ");
        for(int i = 0; i < words.length; i++){
            result += words[i].charAt(0);
        }
        
        return result;
    }
}
