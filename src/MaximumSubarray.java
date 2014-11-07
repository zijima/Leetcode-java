/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
	/////
    public int maxSubArray(int[] a) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int max = Integer.MIN_VALUE;
        int maxHere = 0;
        for (int i = 0; i < a.length; i++){
            maxHere = Math.max(a[i], maxHere + a[i]);
            max = Math.max(max, maxHere);
        }
        return max;
    }
}
