package LeetCode.Linked_List.P141_Linked_List_Cycle;
import java.util.*;

public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSeen = new HashSet<>();

        while(head != null) {
            if (nodeSeen.contains(head)) {
                return true;
            } else {
                nodeSeen.add(head);
            }
            head = head.next;
        }

        return false;
    }
}
