/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] num) {
        if (num == null){
            return 0;
        }
        int l = num.length;
        if (l == 0){
            return 0;
        }
        
        return helper(num, 0, l - 1);
    }
    
    private int helper(int[] num, int start, int end){
        int mid = (start + end) / 2;
        if (start == end){
            return num[start];
        }
        
        if (start + 1 == end){
            return Math.min(num[start], num[end]);
        }
        
        
        if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]){
            //mid is max
            return helper(num, mid + 1, end);
        }
        if (num[mid] > num[mid - 1] && num[mid] < num[mid + 1]){
            //
            if (num[mid] > num[start] && num[mid] > num[end]){
                return helper(num, mid + 1, end);
            } else {
                return helper(num, start, mid - 1);
            }
        }
        return num[mid];
    }
}
