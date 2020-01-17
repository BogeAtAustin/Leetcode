package leetCode;

public class _404SumOfLeftLeaves {

    /**
     * Find the sum of all left leaves in a given binary tree.
     * 关键是怎样定义左叶子
     */

    //S1:
    // using global variable but not passing through the callee method
    private int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        traversal(root);
        return sum;
    }
    private void traversal(TreeNode node){
        if(node == null){
            return;
        }
        if(node.left != null){
            //leave and node are different. leave means it doesn't has left or right child
            if(node.left.left == null && node.left.right == null){
                sum += node.left.val;
            }

        }
        traversal(node.left);
        traversal(node.right);
    }
}
