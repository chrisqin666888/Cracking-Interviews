package LeetCode.Array_Medium_Hard.P60_Permutation_Sequence;
import java.util.*;

public class Solution {
    public String getPermutation(int n, int k) {
        char[] result = new char[n];
        ArrayList<Integer> nums = new ArrayList<>();

        int[] factorial = new int[n];
        factorial[0] = 1;

        for(int i = 1; i < n; i++) {
            factorial[i] = factorial[i-1] * i;
        }

        for(int i = 1; i <= n; i++) {
            nums.add(i);
        }
        k--;

        for(int i = 0; i < n; i++) {
            result[i] = Character.forDigit(nums.remove(k / factorial[n - 1- i]), 10);
            k = k % factorial[n - 1 - i];
        }

        return new String(result);
    }
}
