package leetCode;

public class _033SearchInRotatedSortedArray {

    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     *
     * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
     *
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     * @param nums
     * @param target
     * @return
     */

    //分两类情况，一类是mid的值大于end的值，一类是mid的值小于end的值。然后每一类里面，才去定义指针的走向。
    //这道题与最基本的binary search不同的地方在于，先得分情况

    //再做这道题时，画出两种不同情况的曲线图，这样会很有帮助

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            System.out.println(mid);
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > nums[end]){
                if(target >= nums[start] && target < nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                if(target > nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
