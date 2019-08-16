package leetCode;

import java.util.ArrayList;
import java.util.List;

public class _229MajorityElement2 {
//    Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
//    Note: The algorithm should run in linear time and in O(1) space.
        public List<Integer> majorityElement(int[] nums) {
            //思路是首先得确定最多有几个majority element，发现是最多两个，最少没有。
            //然后用两个candidate来装
            List<Integer> res = new ArrayList<>();
            if(nums.length == 0){
                return res;
            }
            //because the conginue in the for loop, it's ok to set
            //both can initialize to nums[0]
            int can1 = nums[0], can2 = nums[0], len = nums.length;
            int count1 = 0, count2 = 0;

            for(int num : nums){
                if(num == can1){
                    count1++;
                    // use continue to avoid can2 got count.
                    continue;
                }
                if(num == can2){
                    count2++;
                    continue;
                }
                if(count1 == 0){
                    can1 = num;
                    count1 = 1;
                    continue;
                }
                if(count2 == 0){
                    can2 = num;
                    count2 = 1;
                    continue;
                }else{
                    count1--;
                    count2--;
                }
            }
            count1 = 0;
            count2 = 0;
            // you just found potential candidates, have to verify
            for(int num : nums){
                if(num == can1){
                    count1++;
                    // to prevent can1 == can2
                    //e.g. if all num == can1, then count2 will be 0
                    continue;
                }
                else if(num == can2){
                    count2++;
                }
            }
            if(count1 > len / 3){
                res.add(can1);
            }
            if(count2 > len / 3){
                res.add(can2);
            }
            return res;
        }

}
