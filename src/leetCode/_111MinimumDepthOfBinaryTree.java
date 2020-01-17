package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class _111MinimumDepthOfBinaryTree {

    //Given a binary tree, find its minimum depth.

    //这道题与Level Order Traversal那题一模一样，重在凸显BFS在求最短路径的优势。BFS只要找到一个终点（这里终点指遇到Leaf），那么该路径一定是最短
    //DFS却不一定

    //BFS
    //Time: O(N) Space: O(N)
    public int minDepth(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return result;

        queue.offer(root);

        while(!queue.isEmpty()){
            result++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null){
                    return result;
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }

    //DFS, 用DFS去findDepth，就要涉及到比较得到最小的值，BFS不需要比较
    //T：O（N），S： O（h） h = height
    public int minDepth2(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left == 0 || right == 0){
            return left + right + 1;
        }else{
            return Math.min(left, right) + 1;
        }

    }

    //虽然两个解法的平均T&S好像一样，但是如果最优解在左子树上，BFS还是要快于DFS
}
