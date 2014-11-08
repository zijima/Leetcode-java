/*
 * Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 */
public class Roman2Integer {
    //I-1
    //V-5
    //X-10
    //L-50
    //C-100
    //D-500
    //M-1000
    public int romanToInt(String s) {
        char[] roman = s.toCharArray();
        int result = 0;
        
        for (int i = 0; i < roman.length; i++){
            if (i == roman.length - 1){
                result = result + getInt(roman[i]);
                break;
            }
            int current = getInt(roman[i]);
            int next = getInt(roman[i + 1]);
            if (current >= next){
                result = result + current;
            } else {
                result = result + (next - current);
                i++;
            }
        }
        return result;
    }
    
    private int getInt(char c){
        int n = 0;
        if (c == 'I'){
            n = 1;
        } else if (c == 'V'){
            n = 5;
        } else if (c == 'X'){
            n = 10;
        } else if (c == 'L'){
            n = 50;
        } else if (c == 'C'){
            n = 100;
        } else if (c == 'D'){
            n = 500;
        } else if (c == 'M'){
            n = 1000;
        }
        return n;
    }
}
