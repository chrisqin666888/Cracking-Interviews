package LeetCode.Linked_List.P86_Partition_List;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode left = dummy1;
        ListNode dummy2 = new ListNode(0);
        ListNode right = dummy2;

        while(head != null) {
            ListNode temp = new ListNode(head.val);
            if (head.val < x) {
                left.next = temp;
                left = left.next;
            } else {
                right.next = temp;
                right = right.next;
            }
            head = head.next;
        }

        left.next = dummy2.next;
        return dummy1.next;
    }
}
