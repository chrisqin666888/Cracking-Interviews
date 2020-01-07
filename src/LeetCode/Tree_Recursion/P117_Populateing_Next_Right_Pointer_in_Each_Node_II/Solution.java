package LeetCode.Tree_Recursion.P117_Populateing_Next_Right_Pointer_in_Each_Node_II;

public class Solution {
    public Node connect(Node root) {
        Node res = root;
        Node dummy = new Node(0);
        Node pre = dummy;
        while(res!=null){
            while(res!=null){
                if(res.left!=null) {
                    pre.next = res.left;
                    pre = pre.next;
                }

                if(res.right!=null) {
                    pre.next = res.right;
                    pre = pre.next;
                }
                res = res.next;
            }
            res = dummy.next;
            dummy.next = null;
            pre = dummy;
        }
        return root;
    }
}
