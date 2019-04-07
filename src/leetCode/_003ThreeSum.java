package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _003ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res =new ArrayList<>();
        //ATTN
        if(nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            //ATTN
            if(nums[i] > 0) break;
            int k = i + 1;
            int j = nums.length - 1;

            //在while里面建立大框架的框架，if，elseif，else 然后再填充
            while(k < j){
                if(nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> com = new ArrayList<>();
                    com.add(nums[i]);
                    com.add(nums[k]);
                    com.add(nums[j]);

                    res.add(com);

                    while(i < j && nums[i] == nums[i + 1]){
                        i++;
                    }
                    while(k < j && nums[j] == nums[j - 1]){
                        j--;
                    }
                }else if(nums[i] + nums[j] + nums[k] < 0){
                    i++;
                }else{
                    j--;
                }
            }
        }
        return res;
    }
}
