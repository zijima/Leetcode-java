/*
 * Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int l = digits.length;
        if (l == 0){
            return null;
        }
        int sum = digits[l - 1] + 1;
        int p = sum / 10;
        digits[l - 1] = sum % 10;
        for (int i = l - 2; i >= 0; i--){
            sum = digits[i] + p;
            p = sum / 10;
            digits[i] = sum % 10;
        }
        
        if (p == 1){
            int[] result = new int[l + 1];
            result[0] = 1;
            for (int i = 1; i < l + 1; i++){
                result[i] = digits[i - 1];
            }
            return result;
        }
        return digits;
    }
}
