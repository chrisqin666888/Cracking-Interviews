package LeetCode.Array_Medium_Hard.P134_Gas_Station;

import java.util.Arrays;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) return -1;
        int total_left_gas_after_consumption = 0;
        int current_gas = 0;
        int start = 0;

        for(int i = 0; i < cost.length; i++) {
            current_gas += gas[i] - cost[i];

            if (current_gas < 0) {
                start = i + 1;
                current_gas = 0;
            }

            total_left_gas_after_consumption += gas[i] - cost[i];
        }

        return total_left_gas_after_consumption >= 0 ? start : -1;
    }
}
