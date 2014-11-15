/*
 * Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
 */
//TODO: rework this one...
public class ReverseWordsInAString {
	public static void main(String[] args) {
		ReverseWordsInAString re = new ReverseWordsInAString();
		System.out.println(re.reverseWords("my name    is    "));
	}
    public String reverseWords(String s) {
        if (s == null){
            return s;
        }
        
        char[] c = s.toCharArray();
        int l = c.length;
        
        int start = 0;
        int end = l - 1;
        //remove leading and trailing spaces
        for (int i = 0; i < l;){
            if (c[i] == ' '){
                i++;
                start++;
                continue;
            }
            break;
        }
        for (int i = l - 1; i >= 0;){
            if (c[i] == ' '){
                i--;
                end--;
                continue;
            }
            break;
        }
        if (start > l - 1){
        	return "";
        } else if (start > end){
        	return s.substring(start, l);
        }
        
        //reverse entire string
        // the sky => yks eht
        reverse(c, start, end);
        
        //reverse each word, separated by space
        int wordStart = start;
        for (int i = start; i <= end; i++){
        	if (i == end){
        		reverse(c, wordStart, end);
        		break;
        	}
            if (c[i] == ' '){
                reverse(c, wordStart, i - 1);
                //find next start
                for (int j = i + 1; j <= end; j++){
                    if (c[j] != ' '){
                        wordStart = j;
                        i = j;
                        break;
                    }
                }
            }
        }
        
        //remove all extra spaces
        boolean hasSpace = false;
        StringBuilder builder = new StringBuilder();
        for (int i = start; i <= end; i++){
            if (c[i] == ' '){
            	if (hasSpace){
            		continue;
            	}
            	builder.append(c[i]);
                hasSpace = true;
            }else {
            	builder.append(c[i]);
            	hasSpace = false;
            }
        }
        return builder.toString();
    }
    
    private void reverse(char[] c, int start, int end){
        int l = end - start + 1;
        for (int i = 0; i < l / 2; i++){
            swap(c, start + i, start + l - i - 1);
        }
    }
    
    private void swap(char[] c, int start, int end){
        char tmp = c[start];
        c[start] = c[end];
        c[end] = tmp;
    }
}
