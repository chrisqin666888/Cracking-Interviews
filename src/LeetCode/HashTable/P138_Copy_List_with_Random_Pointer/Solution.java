package LeetCode.HashTable.P138_Copy_List_with_Random_Pointer;
import java.util.*;

public class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node current_node = head;
        while (current_node != null) {
            map.put(current_node, new Node(current_node.val));
            current_node = current_node.next;
        }

        current_node = head;
        while (current_node != null) {
            map.get(current_node).next = map.get(current_node.next);
            map.get(current_node).random = map.get(current_node.random);
            current_node = current_node.next;
        }

        return map.get(head);
    }
}
