package leetCode;

public class _74SearchA2DMatrix {


    //把他当成一维数组来对待，mid 就是所有元素摊开一条线的中点，
    //然后根据中点和column的值就能转换成该点在二维数组的位置
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m * n - 1;

        while(start <= end){
            int mid = (end - start) / 2 + start;
            if(matrix[mid / n][mid % n] == target){
                return true;
            }else if(matrix[mid / n][mid % n] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }
    //Note：如果题目没有"每列最后一个元素都小于下一行第一个元素"的限定，
    //你会怎么做？
    boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0||matrix[0].length == 0) return false;
        int start = 0, end = matrix.length - 1;
        while (start + 1 < end) {
            int mid = (end - start)/2 + start;
            if (matrix[mid][0] < target) start = mid;
            else end = mid;
        }
        int new_start = 0,new_end = matrix[0].length-1;
        int index = matrix[end][0] <= target ?end:start;
        while (new_start + 1 < new_end) {
            int mid = (new_end - new_start)/2 + new_start;
            if (matrix[index][mid] > target) new_end = mid;
            else if (matrix[index][mid] < target)
                new_start = mid;
            else return true;
        }
        if (matrix[index][new_end] == target) return true;
        if (matrix[index][new_start] == target) return true;
        return false;
    }
}
