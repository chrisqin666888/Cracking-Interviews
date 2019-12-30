package LeetCode.Linked_List.P143_Reorder_Linked_List;

public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        // head of first half
        ListNode l1 = head;
        // head of second half
        ListNode slow = head;
        // tail of second half
        ListNode fast = head;
        // tail of first half
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode l2 = reverse(slow);
        merge(l1, l2);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current_node = head;

        while (current_node != null) {
            ListNode next_node = current_node.next;
            current_node.next = prev;
            prev = current_node;
            current_node = next_node;
        }

        return prev;
    }

    private void merge(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;
            l1.next = l2;
            if (l1_next == null) break;

            l2.next = l1_next;
            l1 = l1_next;
            l2 = l2_next;
        }
    }
}
