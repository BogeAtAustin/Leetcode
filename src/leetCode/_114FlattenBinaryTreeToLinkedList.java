package leetCode;

import java.util.Stack;

public class _114FlattenBinaryTreeToLinkedList {
    /**
     * Given a binary tree, flatten it to a linked list in-place.
     */

    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
            if(!stack.isEmpty()){
                node.right = stack.peek();
            }
            node.left = null;
        }
    }
}
