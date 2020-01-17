package leetCode;

public class _236LowestCommonAncestorOfABinaryTree {


    /**
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
     */

    //前提是p 和 q 一定在树里面
    //题目中还加上了All the node value will be unique的条件，感觉是主要避免p = q 或 多个 p / 多个 q 出现造成多种答案的情况


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Edge/Condition 如果找到p 或者 q,返回它
        if(root == null || root == p || root == q){
            return root;
        }
        //分治法 递归对左边和右边进行搜索
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //如果对左边和右边都遍历完，left 和 right 都返回不为Null的值，那么作为left 和 right 的 root 就是LCA了
        if(left != null && right != null) return root;
        //把整个树的左子树都遍历完了都找不到p或q中任何一个，那么肯定是在柚子树了，只要找到第一个match p/q的点，直接返回right，剩下的紫薯都不用搜索了
        if(left == null) return right;
        else
            return left;

        //一定要画图来理解，要问自己，图理解透了吗？

        //
        //              ——————————3——————————
        //              /                    \
        //       ———————5———————       ——————1———————
        //       /              \      /            \
        //      6               2     0              8
    }   //                      /\
        //                     7  4

        // Case 1: p = 5, q = 1  left 遍历左子树 返回 5， right 遍历柚子树返回1， 都不为null, 就返回它们的root，就是3
        // Case 2: p = 1, q = 8 left 遍历左子树 都没找到，只能返回null, right遍历柚子树返回1，停止遍历直接返回，right = p = LCA
}
