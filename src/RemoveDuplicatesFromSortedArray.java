/*
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2]
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] a) {
        if (a.length == 0 || a.length == 1){
            return a.length;
        }
        //int fast = 0;
        int slow = 0;
        for (int fast = 1; fast < a.length; ){
            while(a[fast] <= a[slow]){
                if(fast == a.length - 1){
                    return slow + 1;
                }
                fast++;
            }
            swap(a, fast, ++slow);
        }
        return slow + 1;
    }
    
    private void swap(int[] num, int i, int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
