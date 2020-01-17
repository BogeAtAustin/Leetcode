package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class _226InvertBinaryTree {

    //recursion
    // think about where the first subtree got inverted.
    public TreeNode invertTree1(TreeNode root) {
        if(root == null ) return null;
        TreeNode right = invertTree1(root.right);
        TreeNode left = invertTree1(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
    //Iteration
    public TreeNode invertTree2(TreeNode root){
            if(root == null) return null;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;

                if(node.left != null )queue.add(node.left);
                if(node.right != null )queue.add(node.right);
            }
            return root;
    }
}
