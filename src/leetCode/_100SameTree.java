package leetCode;

public class _100SameTree {

    /**
     *
     * Given two binary trees, write a function to check if they are the same or not.
     */

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }else{
            return false;
        }

    }
}
