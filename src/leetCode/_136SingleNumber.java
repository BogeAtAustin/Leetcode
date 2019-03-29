package leetCode;

import java.util.HashMap;
import java.util.Map;

public class _136SingleNumber {

        public int singleNumber1(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int result = Integer.MAX_VALUE;
            for(int num : nums){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            for(Map.Entry entry : map.entrySet()){
                if((int)entry.getValue() == 1){
                    result = (int)entry.getKey();
                }
            }
            return result;
        }

    public int singleNumber2(int[] nums) {
        int result = 0;
        for(int num : nums){
            result = result ^ num;
        }
        return result;
    }
}
