package leetCode;

public class _035SearchInsertPosition {

    /**
     * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     * <p>
     * You may assume no duplicates in the array.
     */

    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

/**
 * Note1: while(start <= end)这个等于号用的超级妙。首先它可以包括只有一个元素的数组情况，其次，如果target比最大的数子还要大，start是可以大于end+1的，
 * 再次，如果target比最小的数字还要小，end会最终变成-1，但是返回start的话就是0，就是数组的开头。
 */

    /**
     * Note2: 两种定义mid的形式，mid = start + (end - start) /2 和 mid = (tart + end) / 2，第一种更好，prevent overflow where start + end >= 1<<32
     */

    public int searchInsert2(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        if (nums.length == 1) {
            if (nums[start] == target) {
                return start;
            }
        }

        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                //note: end 不是 mid - 1
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        //因为while循环里start不能等于end，如果target真的是数组头尾的任何一个，while里面不能返回
        if (nums[start] >= target) {
            return start;

        } else {
            return start + 1;
        }

    }
}