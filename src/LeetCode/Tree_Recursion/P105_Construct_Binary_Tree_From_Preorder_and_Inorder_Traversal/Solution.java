package LeetCode.Tree_Recursion.P105_Construct_Binary_Tree_From_Preorder_and_Inorder_Traversal;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length!=inorder.length) return null;
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode build(int [] preorder, int preLow, int preHigh, int[] inorder, int inLow, int inHigh){

        // preLow -> left boundary of preorder array, initial val = 0
        // preHigh -> right boundary of preorder array, initial val = length of preorder array
        // inLow -> left boundary of inorder array, initial val = 0
        // inHigh -> right boundary of inorder array, initial val = length of inorder array

        // if left boundary exceed right boundary, break recursion and return null;
        if(preLow > preHigh || inLow > inHigh) return null;

        // The initial root is always the first element of the preorder array
        TreeNode root = new TreeNode(preorder[preLow]);

        // we need to find the position of the root in the inorder array, we will do a linear search
        // if we find it, then we know the left subarray of this root is the left hand tree and the right is the right hand tree
        int inorderRoot = inLow;
        for(int i = inLow; i <= inHigh; i++){
            if(inorder[i] == root.val){
                inorderRoot=i;
                break;
            }
        }

        // the left tree's length is the root index we find minus the left start point, first iteration is 0;
        int leftTreeLen = inorderRoot-inLow;

        // recursively call the array.
        // for the left hand side
        root.left = build(preorder, preLow+1, preLow+leftTreeLen, inorder, inLow, inorderRoot-1);
        root.right = build(preorder, preLow+leftTreeLen+1, preHigh, inorder, inorderRoot+1, inHigh);
        return root;
    }
}
