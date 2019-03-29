package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _350IntersectionOfTwoArray2 {

//    Given two arrays, write a function to compute their intersection.
//
//            Example 1:
//
//    Input: nums1 = [1,2,2,1], nums2 = [2,2]
//    Output: [2,2]
//    Example 2:
//
//    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//    Output: [4,9]
//    Note:
//
//    Each element in the result should appear as many times as it shows in both arrays.
//    The result can be in any order.
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for(int num : nums2){
            if(map.containsKey(num) && map.get(num) > 0){
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }

}
