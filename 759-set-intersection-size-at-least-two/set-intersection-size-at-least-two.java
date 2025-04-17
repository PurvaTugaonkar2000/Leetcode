import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[1] != b[1]) {
                    return Integer.compare(a[1], b[1]);      
                }
                return Integer.compare(b[0], a[0]);          
            }
        });
        
        int x = -1, y = -1;  
        int res = 0;
        
        for (int[] iv : intervals) {
            int a = iv[0], b = iv[1];
            
            if (a > y) {
                
                x = b - 1;
                y = b;
                res += 2;
            } else if (a > x) {
                
                x = y;
                y = b;
                res += 1;
            }
            
        }
        
        return res;
    }
    
    // Example test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals = {{1,3}, {1,4}, {2,5}, {3,5}};
        System.out.println(sol.intersectionSizeTwo(intervals));  // prints 3
    }
}
