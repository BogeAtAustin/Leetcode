package leetCode;

public class _027RemoveElement {

    public int removeElement1(int[] nums, int val) {
        int target = 0;
        if(nums == null || nums.length == 0) {
            return 0;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[target] = nums[i];
                target++;
            }
        }
        return target;
    }

    //S2
    public int removeElement2(int[] nums, int val) {
        int target = -1, current = 0, count = 0;
        if(nums == null || nums.length == 0) {
            return 0;
        }
        while(current < nums.length){
            if(nums[current] == val){
                if(target == -1){
                    target = current;
                }
                count++;
            }else{
                if(target != -1){
                    nums[target] = nums[current];
                    target++;
                }
            }
            current++;
        }
        return nums.length - count;
    }
}
