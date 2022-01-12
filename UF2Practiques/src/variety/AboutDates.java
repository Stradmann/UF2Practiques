
package variety;

public class AboutDates {
    
    public static boolean isLeapYear(int year){
        
        boolean result;
        
        if(year % 4 == 0){
            if(year % 100 == 0){
                if(year % 400 == 0){
                    result = true;
                }else{
                    result = false;
                }
            }else{
                result = true;
            }
        }else{
            result = false;
        }
        
        return result;
    }
    
    public static int daysInMonth(int month, int year){
        int days;
        
        if(month == 2){
            if(isLeapYear(year))
                days = 29;
            else
                days = 28;
        }else if(month == 4 || month == 6 || month == 9 || month == 11){
            days = 30;
        }else{
            days = 31;
        }
        
        return days;
    }
}
