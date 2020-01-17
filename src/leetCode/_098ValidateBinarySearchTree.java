package leetCode;

import java.util.ArrayList;
import java.util.List;

public class _098ValidateBinarySearchTree {

    /**
     * Given a binary tree, determine if it is a valid binary search tree (BST).
     */

    /**
     * 每一个左紫薯都有自己的最大值限定，每一个右紫薯也有自己的最小限定，如果在这个限定区间内，即符合BST定义
     *
     */

    public boolean isValidBST1(TreeNode root) {
        long min = Long.MIN_VALUE, max = Long.MAX_VALUE;
        return traversal(root, min, max);
    }

    public boolean traversal(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }
        //注意"="这个corner case
        if(root.val <= min || root.val >= max){
            return false;
        }
        return traversal(root.left, min, root.val) && traversal(root.right, root.val, max);
    }

    /**
     * 利用BST的中序排列一定是从小到大的特性，来证明BST。注意一定是从小到大，等于也不行
     * 缺点是extra space。 time O（N）， Space O（N）
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if(root == null) return true;
        List<Integer> inorder = new ArrayList<>();

        traversal2(root, inorder);
        if(inorder.size() == 1) return true;
        for(int i = 1; i < inorder.size(); i++){
            if(inorder.get(i - 1) >= inorder.get(i)){
                return false;
            }
        }
        return true;
    }
    private void traversal2(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        traversal2(root.left, list);
        list.add(root.val);
        traversal2(root.right, list);
    }
}
