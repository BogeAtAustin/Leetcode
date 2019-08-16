package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _094BinaryTreeInorderTraversal {

    /**
     * Given a binary tree, return the inorder traversal of its nodes' values.
     */

    //Solution 1: Recursion
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }
    public void traversal(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        traversal(root.left, list);
        list.add(root.val);
        traversal(root.right, list);
    }

    //Solution 2: Iteration via Stack
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }
        return result;
    }
}
