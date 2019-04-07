package leetCode;

public class _011ContainerWithMostWater {
    //O(n * n)
    public int maxArea(int[] height) {
        int maxArea = 0;
        //两个pointer都是葱从左开始
        for(int i = 0; i < height.length; i++){
            for(int j = i + 1; j < height.length; j++){
                maxArea = Math.max(maxArea,Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxArea;
    }
    public int maxArea2(int[] height){
        int maxArea = 0;
        //两个pointer是分别从数组两边开始，往中间靠近
        int i = 0, j = height.length - 1;

        while(i < j){
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            //收敛的过程
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxArea;
    }
}
