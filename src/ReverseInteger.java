/*
 * Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
 */
public class ReverseInteger {
    public int reverse(int x) {
        int neg = 1;
        if (x < 0){
            neg = -1;
            x = -x;
        }
        int result = 0;
        while (x != 0){
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result * neg;
    }
}
