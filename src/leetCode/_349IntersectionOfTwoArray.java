package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _349IntersectionOfTwoArray {
//    Given two arrays, write a function to compute their intersection.
//
//            Example 1:
//
//    Input: nums1 = [1,2,2,1], nums2 = [2,2]
//    Output: [2]
//    Example 2:
//
//    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//    Output: [9,4]
//    Note:
//
//    Each element in the result must be unique.
//    The result can be in any order.

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                list.add(num);
                //critical one
                set.remove(num);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

}
