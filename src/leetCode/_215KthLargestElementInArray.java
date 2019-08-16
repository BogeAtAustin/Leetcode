package leetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _215KthLargestElementInArray {

    //Time： O(nlogn), Space O(1)
    public int findKthLargest1(int[] nums, int k){
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    //Time: O(nlogK), Space O(k)
    public int findKthLargest2(int[] nums, int k){
        PriorityQueue<Integer> queue =new PriorityQueue<>(k, (a, b) -> b - a);
        for(int num : nums){
            queue.offer(num);
        }
        //the kth is k-1 in index
        for(int i = 0; i < k - 1; i++){
            queue.poll();
        }
        return queue.peek();
    }
    //Time: O(n), worst O(n * n), space O(1)
    //https://en.wikipedia.org/wiki/Quickselect
    //Quick Select is related to QuickSort (O(n log n)), but it only includes partition section which have an average
    //time (O(n) + O(n/2) + O(n /4) + ....) roughly equals to O(n)
    public int findKthLargest3(int[] nums, int k){
        return helper(nums, 0, nums.length - 1, k);
    }

    private int helper(int[] nums, int l, int r, int k){
        if(l == r){
            return nums[l];
        }
        int position = partition(nums, l, r);
        //k start from 1, position start from 0
        if(position + 1== k){
            return nums[position];
        }else if(position + 1 < k){
            //k larget, search the second half of array
            return helper(nums, position + 1, r, k);
        }else{
            // k smaller, means the number is bigger than pivot. so search left
            return helper(nums, l, position - 1, k);
        }
    }
    private int partition(int[] nums, int l, int r) {
        int left = l, right = r;
        int pivot = nums[left];

        while (left < right) {
            // choose left side as pivot, then must move right side at first. vice versa
            //have to keep left < right in inner loop
            //降序，右边小于pivot的就直接跳过
            while (left < right && nums[right] <= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] >= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
