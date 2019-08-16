package leetCode;
//灌水类问题
//通过对撞型指针优化算法，不用扫描多余状态
public class _011ContainerWithMostWater {
    //O(n * n)
    public int maxArea(int[] height) {
        int maxArea = 0;
        //两个pointer都是从左开始
        for(int i = 0; i < height.length; i++){
            for(int j = i + 1; j < height.length; j++){
                maxArea = Math.max(maxArea,Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxArea;
    }

    //O（n）
    public int maxArea2(int[] height){
        int maxArea = 0;
        //两个pointer是分别从数组两边开始，往中间靠近
        int i = 0, j = height.length - 1;

        while(i < j){
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            //收敛的过程
            //比如当i和j时已经是当前最大值了，为了寻找更大的，你当然希望保持住大的,然后
            //寻找把小的替换掉
            if(height[i] < height[j]){
                i++;
            //同上，都是低（小）的移动，高（大）的不动
            //至于==情况下，移动i或j都可以
            }else{
                j--;
            }
        }
        return maxArea;
    }
}
