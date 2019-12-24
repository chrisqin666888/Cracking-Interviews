package Array_Medium_Hard.P539_Minimum_Time_Difference;
import java.util.*;


public class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] time_Seen = new boolean[24*60];
        for(String time: timePoints) {
            String[] hour_minute = time.split(":");
            int hour = Integer.parseInt(hour_minute[0]);
            int minute = Integer.parseInt(hour_minute[1]);
            int time_in_minute = hour * 60 + minute;
            if(time_Seen[time_in_minute]) return 0;
            time_Seen[time_in_minute] = true;
        }

        Integer firstSeen = null;
        Integer prevSeen = null;
        Integer minDiff = Integer.MAX_VALUE;

        for(int i = 0; i < 1440; i++) {
            if (time_Seen[i]) {
                if (firstSeen == null) {
                    firstSeen = i;
                    prevSeen = i;
                } else {
                    minDiff = Math.min(minDiff, Math.min(i - prevSeen, 1440 - (i - prevSeen)));
                    prevSeen = i;
                }
            }
        }

        minDiff = Math.min(minDiff, Math.min(prevSeen - firstSeen, 1440 - (prevSeen - firstSeen)));

        return minDiff;
    }
}
