package LeetCode.PriorityQueue.P23_Merge_K_sorted_Linked_List;
import java.util.*;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) {
                    return -1;
                } else if (o1.val == o2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode res = dummy;

        for(ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while(!queue.isEmpty()) {
            res.next = queue.poll();
            res = res.next;

            if (res.next != null) {
                queue.add(res.next);
            }
        }
        return dummy.next;
    }
}
