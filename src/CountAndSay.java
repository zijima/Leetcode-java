/*
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if(n <= 0){
            return "";
        }
        if(n == 1){
            return "1";
        }
        String last = countAndSay(n - 1);
        StringBuilder builder = new StringBuilder();
       
        int count = 1;
        char lastChar = last.charAt(0);
        for(int i = 1; i < last.length(); i++){
                if(last.charAt(i) == lastChar){
                    count++;
                } else {
                    builder.append(count);
                    builder.append(lastChar);
                    count = 1;
                    lastChar = last.charAt(i);
                }
        }
        builder.append(count);
        builder.append(lastChar);
        return builder.toString();
    }
}
