package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _199BinaryTreeRightSideView {

    //Given a binary tree, imagine yourself standing on the right side of it,
    //return the values of the nodes you can see ordered from top to bottom.

    //要注意的一种情况是，柚子树不存在，那么从右往左看，能看到的就是左子树了。
    //ex.  1
    //   2 null

    //BFS 套模版
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(i == size - 1){
                    res.add(node.val);
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }

    //DFS
    //刚开始的思路就是DFS只往右走。但是发现上面提到的那种情况后，这种思路不通，不能限定只往右走
    //但是无论如何，每一层height就取一个元素
    //所以先存左子树的，如果柚子树存在，那就更新index=height的值，否则，就保持原值
    public List<Integer> rightSideView2(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        dfs(root, 0, res);
        return res;
    }
    private void dfs(TreeNode root, int height,List<Integer> res){
        if(root == null){
            return;
        }
        //新 height，新的元素
        if(height >= res.size()){
            res.add(height, root.val);
        }else{
            //否则，替换掉现有height对应的元素
            res.set(height, root.val);
        }
        dfs(root.left, height + 1, res);
        dfs(root.right, height + 1, res);
    }
}
