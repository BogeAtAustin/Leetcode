package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _015ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res =new ArrayList<>();
        //corner case
        if(nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            //ATTN, per requirement 3 element sum should equals to 0
            if(nums[i] > 0) break;
            int k = i + 1;
            int j = nums.length - 1;

            //在while里面建立逻辑的大框架，if，elseif，else 然后再填充
            while(k < j){
                if(nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> com = new ArrayList<>();
                    com.add(nums[i]);
                    com.add(nums[k]);
                    com.add(nums[j]);

                    res.add(com);

                    //here not i < k
                    while(i < j && nums[i] == nums[i + 1]){
                        i++;
                    }
                    while(k < j && nums[j] == nums[j - 1]){
                        j--;
                    }
                    k++;
                    j--;
                }else if(nums[i] + nums[j] + nums[k] < 0){
                    k++;
                }else{
                    j--;
                }
            }
        }
        return res;
    }
}
