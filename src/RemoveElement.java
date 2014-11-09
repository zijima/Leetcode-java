/*
 * Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
    public int removeElement(int[] a, int elem) {
        int l = a.length;
        int last = l - 1;
        
        for (int i = 0; i <= last; i++){
            if(a[i] == elem){
                //swap(i, last);
                swap(a, i, last);
                i--;
                last--;
                continue;
            }
        }
        return last + 1;
    }
    
    private void swap(int[] num, int i, int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
