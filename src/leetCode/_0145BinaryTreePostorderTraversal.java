package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _0145BinaryTreePostorderTraversal {
    /*
    Given a binary tree, return the postorder traversal of its nodes' values.
     */

    /**
     * Solution1: 一个stack + 一直在index=0插入新元素的List
     * Solution2： 两个Stack， s1先存root，在pass给S2，这样确保S2输出时root在最后。然后S1先左后右，出来后就是先右后左的存入S2，S2出来后就是先左后右了
     * 相当于倒了两次，还是最初的顺序。但是root始终在最后出来（两个stack = 左手倒右手）
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            //Don't know why if without null check, will throws NPE??
            if(node != null){
                result.add(0, node.val);
            }
            if(node.left != null)
                stack.push(node.left);
            if(node.right != null)
                stack.push(node.right);

        }
        return result;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode node = s1.pop();
            s2.push(node);

            if(node.left != null){
                s1.push(node.left);
            }
            if(node.right != null){
                s1.push(node.right);
            }
        }

        while(!s2.isEmpty()){
            result.add(s2.pop().val);
        }

        return result;
    }
}
