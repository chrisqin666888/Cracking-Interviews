package LeetCode.Dynamic_Programming.P322_Coin_Change;
import java.util.*;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;

        for(int current_amount = 1; current_amount <= amount; current_amount++) {
            for(int i = 0; i < coins.length; i++) {
                if (coins[i] > current_amount) break;
                dp[current_amount] = Math.min(dp[current_amount], dp[current_amount - coins[i]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.coinChange(new int[]{1,2,5}, 11));
    }
}
