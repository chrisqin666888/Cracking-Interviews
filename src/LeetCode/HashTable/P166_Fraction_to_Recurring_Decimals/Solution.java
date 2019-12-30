package LeetCode.HashTable.P166_Fraction_to_Recurring_Decimals;
import java.util.*;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if (numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0) sb.append('-');

        long upper = Math.abs((long) numerator);
        long lower = Math.abs((long) denominator);

        sb.append(upper / lower);
        long remainder = upper % lower;
        if (remainder == 0) return sb.toString();

        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }

            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / lower);
            remainder %= lower;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fractionToDecimal(77, 600));
    }
}
