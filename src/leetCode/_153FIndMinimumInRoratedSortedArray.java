package leetCode;

public class _153FIndMinimumInRoratedSortedArray {
    //range有两种情况，start < end 说明没 rotated; start > end 说明包含断层
    //然后mid 有两种情况
    //[4,5,6,7,8,0,1,2] mid的值小比start和end都大
    //【6，7，8，0，1，2，3，4，5】 mid的值比两边都大
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while(start <= end){
            int mid = (end - start) / 2 + start;
            //说明该区域包含断层
            if(nums[start] > nums[end]){
                if(nums[mid] >= nums[end] && nums[mid] >= nums[start]){
                    //[5,1], start has to +1
                    start = mid + 1;
                }else{
                    //[8,0,1,2] if mid is already the smallest, either [start,mid] or                             //[mid,end] is fine.
                    end = mid;
                }
                //该区域不包含断层，那第一个一定是最小的
            }else{
                return nums[start];
            }
        }
        return nums[start];
    }
}
