import java.util.HashMap;
import java.util.Map;

/*
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
    
    public int climbStairs(int n) {
        if (n == 0 || n == 1){
            return 1;
        }
        if (cache.get(n) == null){
            cache.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        } 
        return cache.get(n);
    }
}
