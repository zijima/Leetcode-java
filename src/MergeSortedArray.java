/*
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. 
The number of elements initialized in A and B are m and n respectively.
 */
public class MergeSortedArray {
    public void merge(int a[], int m, int b[], int n) {
        int index = m + n - 1;
        while(m > 0 && n > 0){
            if (a[m - 1] >= b[n - 1]){
                a[index] = a[m - 1];
                m--;
            } else {
                a[index] = b[n - 1];
                n--;
            }
            index--;
        }
        
        if (m == 0){
            while (n > 0){
                a[index] = b[n - 1];
                n--;
                index--;
            }
        }
    }
}
