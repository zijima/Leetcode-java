/*
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. 
 * If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
 * You are responsible to gather all the input requirements up front.
 */
public class StringToInteger {
    public int atoi(String str) {
        int tenthMax = Integer.MAX_VALUE/10;
	    if (str == null || str.length() == 0){
	        return 0;
	    }
	    char[] c = str.toCharArray();
	    int l = str.length();
	    int neg = 1;
	    int result = 0;
	    int i = 0;
	    while (i < l){
	        char cc = c[i];
	        if (cc == '-'){
	            neg = -1;
	            i++;
	            break;
	        } else if (cc == '+'){
	            i++;
	            break;
	        } else if (cc == ' '){
	            i++;
	            continue;
	        } else if (Character.isDigit(cc)){
	            break;
	        }
	        return 0;
	    }
	    
	    for (; i < l; i++){
	        char cc = c[i];
	        if (Character.isDigit(cc)){
	            int x = cc - '0';
	            if (result > tenthMax || (result == tenthMax && x > 7)){
	            	return (neg == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
	            }
	            result = result * 10 + x;
	            continue;
	        }
	        break;
	    }
	    return neg * result;
    }
}
