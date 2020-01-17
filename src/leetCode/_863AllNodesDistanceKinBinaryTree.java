package leetCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class _863AllNodesDistanceKinBinaryTree {
    /**
     * We are given a binary tree (with root node root), a target node, and an integer value K.
     * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
     */

    /**
     * As we know, if the distance from a node to target node is k, the distance from its child to the target node is k + 1 unless the child node is closer to the target node which means the target node is in it's subtree.
     *
     * To avoid this situation, we need to travel the tree first to find the path from root to target, to:
     *
     * store the value of distance in hashamp from the all nodes in that path to target
     * Then we can easily use dfs to travel the whole tree. Every time when we meet a treenode which has already stored in map, use the stored value in hashmap instead of the value from its parent node.As we know, if the distance from a node to target node is k, the distance from its child to the target node is k + 1 unless the child node is closer to the target node which means the target node is in it's subtree.
     *
     * To avoid this situation, we need to travel the tree first to find the path from root to target, to:
     *
     * store the value of distance in hashamp from the all nodes in that path to target
     * Then we can easily use dfs to travel the whole tree. Every time when we meet a treenode which has already stored in map, use the stored value in hashmap instead of the value from its parent node.
     */
    Map<TreeNode, Integer> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        find(root, target);
        search(root, 0, K, res);
        return res;
    }

    private void find(TreeNode root, TreeNode target) {
        if (root == null) {
            return;
        }

        if (root == target) {
            map.put(root, 0);
            return;
        }

        find(root.left, target);
        if (map.containsKey(root.left)) {
            map.put(root, map.get(root.left) + 1);
            return;
        }

        find(root.right, target);
        if (map.containsKey(root.right)) {
            map.put(root, map.get(root.right) + 1);
            return;
        }
        return;
    }

    public void search(TreeNode root, int dis, int K, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (map.containsKey(root)) {
            dis = map.get(root);
        }

        if (dis == K) {
            res.add(root.val);
        }

        search(root.left, dis + 1, K, res);
        search(root.right, dis + 1, K, res);
    }
}
