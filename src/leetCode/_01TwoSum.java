package leetCode;

import java.util.HashMap;

public class _01TwoSum {
    //Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    //
    //You may assume that each input would have exactly one solution, and you may not use the same element twice.
    //
    //Example:
    //
    //Given nums = [2, 7, 11, 15], target = 9,
    //
    //Because nums[0] + nums[1] = 2 + 7 = 9,
    //return [0, 1].

    public int[] twoSum(int[] nums, int target){
        //key saves target - num, value save num's index;
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] result = new int[2];

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                result[0] = map.get(nums[i]);
                result[1] = i;
            }else{
                map.put(target - nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args){
        _01TwoSum object = new _01TwoSum();
        int[] nums = {2,7,11,15};
        int[] result = object.twoSum(nums, 9);
        System.out.println(result[0] + " " + result[1]);

    }
}
