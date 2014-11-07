/*
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
 */
public class SearchInsertPosition {
	public int searchInsertLinear(int[] a, int target) {
        int result = 0;
        for (int i = 0 ; i < a.length ; i++){
            if (a[i] < target){
                result = i + 1;
            } else if (a[i] == target){
                return i;
            } else {
                return result;
            }
        }
        return result;
    }
	
	////////////////////////////
    public int searchInsertBinarySearch(int[] a, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(a.length == 0){
            return 0;
        }
        
        return search(a, target, 0, a.length - 1);
    }
    
    private int search(int[] a, int target, int start, int end){
        int middle = (start + end) / 2;
        if(start > end){
            return start;
        }
        
        if(target == a[middle]){
            return middle;
        }
        
        if(target < a[middle]){
            return search(a, target, start, middle - 1);
        }
        return search(a, target, middle + 1, end);
    }
}
