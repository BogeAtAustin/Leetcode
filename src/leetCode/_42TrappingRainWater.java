package leetCode;

public class _42TrappingRainWater {

    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1,
     * compute how much water it is able to trap after raining.
     */

    //S1: Brute Force. 其实只有出现“两高夹一矮”才可能会存到水.
    //每一坐标i上存多少水是由 1.其自身高度 2.它左边的最高高度left_most 3.它右边的最高高度right_most三种因素决定的。
    // Time O(n*n), space O(1)
    public int trap(int[] height) {
        int ans = 0;
        int size = height.length;

        for(int i = 1; i < size - 1; i++){
            int max_left = 0, max_right = 0;
            for(int j = i; j >= 0; j--){
                max_left = Math.max(max_left, height[j]);
            }
            for(int k = i; k < size; k++){
                max_right = Math.max(max_right, height[k]);
            }
            ans += Math.min(max_left, max_right) - height[i];
        }

        return ans;
    }
    //S1的优化方法，可以事先把对每个坐标求left_most 和 right_most放在循环之外，从而减少时间复杂度
    //Time O(n) Space O(n)
    public int trap2(int[] height) {
        int ans = 0;
        if(height == null || height.length == 0){
            return ans;
        }
        int size = height.length;
        int[] max_left = new int[size];
        int[] max_right = new int[size];

        max_left[0] = height[0];
        for(int i = 1; i < size; i++){
            max_left[i] = Math.max(max_left[i - 1], height[i]);
        }

        max_right[size - 1] = height[size - 1];
        for(int i = size - 2; i >= 0; i--){
            max_right[i] = Math.max(max_right[i + 1], height[i]);
        }

        for(int i = 1; i < size - 1; i++){
            ans += Math.min(max_left[i], max_right[i]) - height[i];
        }

        return ans;
    }
    //S2 双指针
    public int trap3(int[] height) {
        int ans = 0;
        if(height == null || height.length == 0){
            return ans;
        }
        int size = height.length;
        int left_max = 0, right_max = 0;
        int left =0 , right = size - 1;

        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= left_max){
                    left_max = height[left];
                }else{
                    ans += left_max - height[left];
                }
                left++;
            }else{
                if(height[right] > right_max){
                    right_max = height[right];
                }else{
                    ans += right_max - height[right];
                }
                right--;
            }
        }
        return ans;
    }
}
