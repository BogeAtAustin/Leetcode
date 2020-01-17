package leetCode;

import java.util.Arrays;

public class _300LIS {


//    想到这个问题不能改变元素各自的相对顺序，所以我们不能排序，在不能排序的情况下，我们考虑下是否能用动态规划解决。
//
//    定义dp[i]为以ai为末尾的最长递增子序列的长度，故以ai结尾的递增子序列
//
//            要么是只包含ai的子序列
//    要么是在满足j<i并且aj<ai的以ai为结尾的递增子序列末尾，追加上ai后得到的子序列
//    如此，便可建立递推关系，在O(N2)时间内解决这个问题。

    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        //all element initialize as 1
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            //to avoid traverse dp array after all loop done;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
