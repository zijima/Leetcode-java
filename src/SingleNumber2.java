/*
 * Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber2 {
	//TODO
    public int singleNumber(int[] a) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int l = a.length;
        if(l == 0){
            return 0;
        }
        
        int[] tmp = new int[32];
        
        int result = 0;
        
        for (int i = 0; i < 32; i++){
            for (int j = 0; j < l ; j++){
                if(((a[j] >> i) & 1) == 1){
                    tmp[i] = (tmp[i] + 1) % 3;
                }
            }
            result |= tmp[i] << i;
        }
        
        return result;
    }
}
