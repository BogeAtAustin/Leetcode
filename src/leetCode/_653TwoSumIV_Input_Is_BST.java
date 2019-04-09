package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}

public class _653TwoSumIV_Input_Is_BST {
    public boolean findTarget(TreeNode root, int k){
        HashSet<Integer> set = new HashSet<>();

        return dfs(root, k, set);
    }
    private boolean dfs(TreeNode root, int k, HashSet<Integer> set){
        if(root == null){
            return false;
        }
        if(set.contains(k - root.val)){
            return true;
        }else{
            set.add(root.val);
        }
        return dfs(root.left, k, set) || dfs(root.right, k, set);
    }

    public boolean findTarget2(TreeNode root, int k){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return false;
        }
        inorder(root, list);
        int i = 0, j = list.size() - 1;
        while(i < j){
            int sum = list.get(i) + list.get(j);
            if(sum == k){
                return true;
            }else if(sum < k){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
    private void inorder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

}
