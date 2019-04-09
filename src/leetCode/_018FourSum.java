package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _018FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 4){
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i - 1] == nums[i]){
                //不是i++,而是直接结束该次循环
                continue;
            }
            for(int j = i + 1; j < nums.length - 2; j++){
                //[0,0,0,0],当i==0时，j ==1,会导致j移动，最后输出空list
                if(j > i + 1 && nums[j - 1] == nums[j]){
                    //不是j++,而是直接结束该次循环
                    continue;
                }
                int left = j + 1, right = nums.length - 1;
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target) {
                        List<Integer> list =new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        left++;
                        right--;
                        while(left < right && nums[left - 1] == nums[left]){
                            left++;
                        }
                        while(left < right && nums[right + 1] == nums[right]){
                            right--;
                        }
                    }else if(sum < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
