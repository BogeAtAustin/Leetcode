package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class _993CousinsInBinaryTree {

    /**
     * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
     */
    //S1
    //解决两个问题，1: x 和 y 是不是 相同的height； 2: 他们的parent node 是不是同一个
    // 第一个问题： 可以用BFS queue来做，也可以用DFS find height helper 来做。
    // 第二个问题： 希望第一种方法遍历的同时，能把各自的parent node 给存起来，而不是额外做一次遍历
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode xParent = null;
        TreeNode yParent = null;
            if(root == null || root.val == x || root.val == y || x == y){
            return false;
        }
            queue.offer(root);

            while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    if(node.left.val == x){
                        xParent = node;
                    }
                    if(node.left.val == y){
                        yParent = node;
                    }
                    queue.offer(node.left);
                }
                if(node.right != null){
                    if(node.right.val == x){
                        xParent = node;
                    }
                    if(node.right.val == y){
                        yParent = node;
                    }
                    queue.offer(node.right);
                }
                if(xParent != null && yParent != null) {
                    if(xParent == yParent){
                        return false;
                    }
                    else{
                        return true;
                    }
                }
            }
            //整个for loop里面，确保所有的node都是相同的height，所以出了loop没能return true的话，xParent 和 y parent 要重置
            xParent = null;
            yParent = null;
        }
            return false;
    }
}
