package leetCode;

import java.util.HashMap;

public class _0167TwoSumII_InputArraySorted {
    public int[] twoSum1(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int [2];

        for(int i = 0; i < numbers.length; i++){
            if(map.containsKey(numbers[i])){
                res[0] = map.get(numbers[i]) + 1;
                res[1] = i + 1;
            }else{
                map.put(target - numbers[i], i);
            }
        }
        return res;
    }

    public int[] twoSum2(int[] numbers, int target) {
            int[] res =new int[2];
            if(numbers == null || numbers.length < 2){
                return res;
            }
            int i = 0, j = numbers.length - 1;
            while(i < j){
                int sum = numbers[i] + numbers[j];
                if(sum == target){
                    res[0] = i + 1;
                    res[1] = j + 1;
                    //return res; if you have return in here. you still to return it at the end;
                    //so break is better choice in here
                    break;
                }else if(sum < target){
                    i++;
                }else{
                    j--;
                }
            }
            //have to return something outside the while loop. so use break if == target
            return res;
        }

}
