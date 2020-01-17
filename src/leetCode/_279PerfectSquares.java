package leetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _279PerfectSquares {

    //Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

    //BFS
    public int numSquares(int n) {
        //存入同层的相邻节点
        Queue<Integer> queue = new LinkedList<>();
        //记录节点，避免queue存入同样的节点
        HashSet<Integer> set = new HashSet<>();

        int res = 0;
        queue.offer(0);

        while(!queue.isEmpty()){
            res++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int curr = queue.poll();
                int j = 1;
                // 平方和小于目标数字的都是节点的相邻节点，都存进去queue里面
                while(curr + j * j <= n){
                    int temp = curr + j * j;
                    if(temp == n) return res;
                    j++;
                    //避免queue重复记录节点
                    if(set.contains(temp)) continue;
                    queue.offer(temp);
                    set.add(temp);
                }
            }
        }
        return -1;
    }
}
