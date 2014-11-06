
/*
 * Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {
	public int singleNumber(int[] A) {
		int x = A[0];
        int l = A.length;
        for(int i = 1; i < l ; i++){
            x = x ^ A[i];
        }
        return x;
    }
}
