package leetCode;

public class _016ThreeSumCloest {
    public int threeSumCloest(int[] nums, int target){
        if(nums == null || nums.length < 3){
            return 0;
        }
        int result = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length - 2; i++){
            int k = i + 1;
            int j = nums.length - 1;
            while(k < j){
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);
                if(diff == 0){
                    return result;
                }
                if(diff < min){
                    min = diff;
                    result = sum;
                }

                if(sum < target){
                    k++;
                }else{
                    j--;
                }
            }
        }
        return result;
   }
}
