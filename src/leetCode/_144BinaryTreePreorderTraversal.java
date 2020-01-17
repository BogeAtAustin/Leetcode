package leetCode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class _144BinaryTreePreorderTraversal {
    /**
     * Given a binary tree, return the preorder traversal of its nodes' values.
     */
    //Solution 1
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }
    private void traversal(TreeNode root, List<Integer> list){
        if(root == null){  return; }
        list.add(root.val);
        traversal(root.left, list);
        traversal(root.right, list);
    }
    //Solution 2
    //注意因为Stack的性质，要想先pop出左子树，就得先把柚子树存进stack里面
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return result;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return result;
    }
}
