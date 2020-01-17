package leetCode;

/**
 * 最大的要么来自左边，要么来自右边，每一个root， left, right 三者组成的小单元都可以通过这种办法得到最大height，整个树就是由这样的小单元组成的，
 * 所以方法同样适用
 */
public class _104MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return Math.max(left, right);
    }
}
