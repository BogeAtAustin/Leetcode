package leetCode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class _102BinaryTreeLevelOrderTraversal {
    /**
     * Given a binary tree, return the level order traversal of its nodes' values.
     * (ie, from left to right, level by level)
     */
    //Solution 1: 借助Queue把同一level的紫薯线性存放，存放下一level之前，根据queue.size()做循环把元素全部踢出去
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        // that's why queue works in here
        while(!queue.isEmpty()){
            List<Integer> value = new ArrayList<>();
            //注意：必须用变量size将queue初始量保存，而不能直接用queue.size()因为会变化
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
            res.add(value);
        }
        return res;
    }
    //Solution 1.1 Two queue. One save current level, one save next level; 注意while 外loop的条件
    public List<List<Integer>> levelOrder11(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;

        Queue<TreeNode> curr = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        curr.offer(root);

        while(!curr.isEmpty() || !next.isEmpty()){
            List<Integer> list = new ArrayList<>();
            while(!curr.isEmpty()){
                TreeNode node = curr.poll();
                if(node.left != null){
                    next.offer(node.left);
                }
                if(node.right != null){
                    next.offer(node.right);
                }
                list.add(node.val);
            }
            res.add(list);
            curr = next;
            next = new LinkedList<>();
        }
        return res;
    }

    // Solution 2: result每个list的index和树的height一致。借助height这一个变量，能找到result list中的正确位置
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelHelper(root, res, 0);
        return res;
    }
    public void levelHelper(TreeNode root, List<List<Integer>> res, int height){
        if(root == null) return;
        // means the tree traversal moves to next level
        if(height >= res.size()){
            res.add(new ArrayList<>());
        }
        res.get(height).add(root.val);

        levelHelper(root.left, res, height + 1);
        levelHelper(root.right, res, height + 1);
    }
}
