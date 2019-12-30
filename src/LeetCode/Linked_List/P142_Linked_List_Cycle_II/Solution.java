package LeetCode.Linked_List.P142_Linked_List_Cycle_II;
import java.util.*;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodeSeen = new HashSet<>();

        while(head != null) {
            if(nodeSeen.contains(head)) {
                return head;
            } else {
                nodeSeen.add(head);
            }
            head = head.next;
        }

        return null;
    }
}
