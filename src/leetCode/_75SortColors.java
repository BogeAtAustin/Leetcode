package leetCode;

public class _75SortColors {
    public void sortColors1(int[] nums) {
        int[] count = new int[3];

        for(int num : nums){
            count[num]++;
        }
        int index = 0;
        for(int i = 0; i < 3; i++){
            while(count[i] > 0){
                nums[index] = i;
                index++;
                count[i]--;
            }
        }
    }

    public void sortColors2(int[] nums) {
        if(nums == null || nums.length == 1) return;

        int j = 0, k = nums.length - 1;

        // take care of front(0) and end(2), the rest in middle is 1;
        for(int i = 0; i <= k; i++){
            if(nums[i] == 0){
                swap(nums, i, j);
                //points to the previous 0's index + 1
                j++;
            }else if(nums[i] == 2){
                swap(nums, i, k);
                // cuz i will +1 at the end, will skip the one swap from nums[k];
                i--;
                k--;
            }
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
