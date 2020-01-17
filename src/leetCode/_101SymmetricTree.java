package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class _101SymmetricTree {

    /**
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     */

    public boolean isSymmetric1(TreeNode root) {
        if(root == null) return true;
        return compareTree(root.left, root.right);
    }
    // DFS
    private boolean compareTree(TreeNode left, TreeNode right){
        // use left == right is a good way to compare if both left node and right node is null or not
        if(left == null || right == null) {return left == right; }

        if(left.val != right.val) {return false;}

        return compareTree(left.left, right.right) && compareTree(left.right, right.left);
    }

    //BFS. go through two subtree in queue, compare them by level
    public boolean isSymmetric2(TreeNode root) {
        // iteration way
        if(root == null) return true;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(root.left);
        q2.offer(root.right);

        while(!q1.isEmpty() && !q2.isEmpty()){
            TreeNode tmp1 = q1.poll();
            TreeNode tmp2 = q2.poll();
            if((tmp1 == null && tmp2 != null) || (tmp1 != null && tmp2 == null)){
                return false;
            }
            if(tmp1 != null && tmp2 != null){
                if(tmp1.val != tmp2.val){
                    return false;
                }
                //注意，这四个offer必须在tmp1 & tmp2都不为null里面执行

                //Queue的实现一般并不容许插入null，只有LinkedList是一个意外，它容许插入null
                //offer可以把Null存入queue中，queue.size() 不为0
                q1.offer(tmp1.left);
                q1.offer(tmp1.right);

                q2.offer(tmp2.right);
                q2.offer(tmp2.left);
            }
        }
        return true;
    }

    //BFS with one queue
    public boolean isSymmetric3(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while(queue.size() > 1){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if(left != null && right != null){
                if( left.val != right.val)
                    return false;
                else{
                    queue.offer(left.left);
                    queue.offer(right.right);
                    queue.offer(left.right);
                    queue.offer(right.left);
                }
            }
            if(left == null && right != null || left != null && right == null){
                return false;
            }
        }
        return true;
    }
}
