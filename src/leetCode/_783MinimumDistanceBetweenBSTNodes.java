package leetCode;

public class _783MinimumDistanceBetweenBSTNodes {

    /**
     * Given a Binary Search Tree (BST) with the root node root,
     * return the minimum difference between the values of any two different nodes in the tree.
     */

    /**
     * 思路：这里利用了BST的性质，即已经排好序。两个数之间最小的差距发生的可能性只有在%相邻%的两个节点之间。
     * 注意这个相邻不单指root和左右节点的相邻，而是指Inorder顺序中前后两个数的差距。所以只需要Inorder遍历，
     * 用一个中间量prev来储存之前遍历过的节点，来和现在遍历的节点做差。
     *
     * 如果不是BST，Inorder不能解决该问题。
     */

        int min = Integer.MAX_VALUE;
        TreeNode prev = null;
        public int minDiffInBST(TreeNode root) {
            traverse(root);
            return min;
        }
        public void traverse(TreeNode root) {
            if(root == null){
                return;
            }
            traverse(root.left);
            if(prev != null){
                min = Math.min(min, Math.abs(prev.val - root.val));
            }
            prev = root;
            traverse(root.right);
        }
}
