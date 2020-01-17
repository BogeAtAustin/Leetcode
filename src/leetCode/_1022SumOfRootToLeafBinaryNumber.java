package leetCode;

import java.util.ArrayList;
import java.util.List;

public class _1022SumOfRootToLeafBinaryNumber {

    /**
     * Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
     *
     * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
     *
     * Return the sum of these numbers.
     */

    //Note: 实质上就是打印所有的从root开始的路径

    //S1： time: O(N), space O(N)
    public int sumRootToLeaf(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null){
            return 0;
        }
        int sum = 0;
        StringBuffer sb = new StringBuffer();
        traversal(root, res, sb);
        for(int i = 0; i < res.size(); i++){
            System.out.println(res.get(i));
            sum += Integer.valueOf(res.get(i),2);
        }
        return sum;
    }

    private void traversal(TreeNode root, List<String> res, StringBuffer sb){
        if(root == null){
            return;
        }
        sb.append(root.val);
        //if 可以去掉，因为如果为null也会return
        if(root.left != null){
            traversal(root.left, res, sb);
        }
        if(root.right != null){
            traversal(root.right, res, sb);
        }
        //注意，只有同时left和right都为0 才是路径的终点，而不是root==null就行了
        if(root.left == null && root.right == null){
            res.add(sb.toString());
        }
        //为什么下面这行代码不放进left和right都为空的condition里面呢，这是因为不仅到了leave时要回退，回退到了非root节点的时候也要回退，因为这些非root非leave节点并不符合left和right
        //都为空。 那为什么root节点不会被回退删除掉呢，那是因为之前都只是在root的左子树，一旦左子树扫完了，就扫右紫薯了，那么root对应的下面这句话就没有机会执行，所以不存在扫完左子树回退时
        //会把root也回退删除掉的情况

        //不需要判断sb.length()是否为0的情况，因为root不会被删除，为0就不可能发生
        sb.setLength(sb.length() - 1);

        //在整棵树遍历完后，sb最终也会把root deleted， sb 为空

    }

    //S2 位运算 + DFS
    //为什么这个方法不需要跟S1一样回溯时删除或者减去呢？
    //因为S1中sb是一个Object的引用，虽然它是一个局部变量（local variable）但是递归中对它的修改其实是对它指向的object的修改，sb 这个引用的内存位置（object）一直没变化，只是Object的内容变化了
    //而S2方法中，val 是primitive的局部变量，递归中对它数值的改变只在一次调用栈中变化，出了这个栈后，数字还是原来的。这也就是为何S2中当左紫薯和柚子树都扫完了回退到parent node的时候，val 还是原来的，不受之前扫完紫薯的影响

    //根据Head First Java，all local variables live on the stack, in the frame corresponding to the method where the variables are declared.
    //Object reference variables work just like primitive variables - if the reference is declared as a local variable, it goes on the stack.
    //All Objects live in the heap, regardless of whether the reference is a local or instance variable.
    //object的reference跟primitive 一样，都只活在某个栈里面，出了这个栈，它们的数字不会因为出栈之前被改变而变化。但是reference是指向一个object，这个object对所有调用它的函数栈来说是共同财产（类似全局变量），一个栈通过reference
    //对这个object的影响会反映在另一个栈中。这就是S1需要回溯操作，而S2不需要的根本原因
    int ans = 0;
    public int sumRootToLeaf2(TreeNode root){
        dfs(root, 0);
        return ans;
    }
    private void dfs(TreeNode root, int val){
        if(root == null) return;
        val = val <<1 | root.val;
        if(root.left == null && root.right == null){
            ans+= val;
        }
        dfs(root.left, val);
        dfs(root.right, val);
    }

}
