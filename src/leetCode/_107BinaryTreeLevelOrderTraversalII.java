package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _107BinaryTreeLevelOrderTraversalII {

    /**
     * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
     * (ie, from left to right, level by level from leaf to root).
     */

    //和102 类似，稍加修改即可
    //S1：
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        // that's why queue works in here
        while(!queue.isEmpty()){
            List<Integer> value = new ArrayList<>();
            int size = queue.size();
            // make sure all previous level got pop and save into list
            for(int i = 0; i < size; i++){
                TreeNode head = queue.poll();
                // add to the tail of queue
                if(head.left != null){
                    queue.add(head.left);
                }
                if(head.right != null){
                    queue.add(head.right);
                }
                value.add(head.val);
            }
            res.add(0, value);
        }
        return res;
    }

    //S2： DFS

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelHelper(root, res, 0);
        return res;
    }
    public void levelHelper(TreeNode root, List<List<Integer>> res, int height){
        if(root == null) return;
        // means the tree traversal moves to next level
        if(height >= res.size()){
            res.add(0, new ArrayList<>());
        }

        levelHelper(root.left, res, height + 1);
        levelHelper(root.right, res, height + 1);
        res.get(res.size() - height - 1).add(root.val);
    }
}
