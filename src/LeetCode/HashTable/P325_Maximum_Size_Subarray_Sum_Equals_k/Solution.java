package LeetCode.HashTable.P325_Maximum_Size_Subarray_Sum_Equals_k;
import java.util.*;

public class Solution {
    public int maxSubArrayLen(int[] arr, int k) {
        if(arr == null || arr.length == 0)
            return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int len = 0;
        int sum = 0;
        for(int i = 0;i < arr.length;i++) {
            sum += arr[i];
            if(map.containsKey(sum - k))
                len = Math.max(i - map.get(sum - k),len);
            if(!map.containsKey(sum))
                map.put(sum,i);
        }
        return len;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input = new int[]{1, -1, 5, -2, 3};
        System.out.println(s.maxSubArrayLen(input, 3));
    }
}
