package leetCode;

public class _034FindFirstAndLastPositionOfElementInSortedArray {

    //S1: has two method to handle lower bound and higher bound, binary search in three places.
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int[] res = {-1, -1};
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == nums[mid]){
                res[0] = searchLeft(nums,start, mid, target);
                res[1] = searchRight(nums,mid, end, target);
                return res;
            }else if (nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return res;
    }

    private int searchLeft(int[] nums, int start, int end, int target){

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }
    private int searchRight(int[] nums, int start, int end, int target){

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return end;
    }

    //S2: by search target & target + 1, this great idea can reuse one binary search methods.
    public int[] searchRange2(int[] A, int target) {
        if (A == null || A.length == 0)     return new int[]{-1, -1};
        int start = firstGreaterOrEqual(A, target);
        if (start == A.length || A[start] != target) {
            return new int[]{-1, -1};
        }
        //target + 1 may overflow, can add if the last element == target or not. if equal, then return length - 1, if not,
        //you don't need to worry overflow at all. Because there has bigger or equal number as target + 1
        int end = firstGreaterOrEqual(A, target + 1);
        return new int[]{start, A[end] == target? end: end-1};
    }

    public int firstGreaterOrEqual(int[] A, int target) {
        int low = 0, high = A.length - 1;
        //think about [1] 1
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (A[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if(target == A[low]) return low;
        else return high;
    }
}

//这道题其实是可以分成三道题的，find the first element, find the last lement, and find the range.

