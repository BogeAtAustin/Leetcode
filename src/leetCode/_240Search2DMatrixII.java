package leetCode;

public class _240Search2DMatrixII {


    //O(m + n) 把矩阵右上角的元素作为起点，如果这个值<target,则该元素所在的行可以排出，
    //如果这个值 > target,则所在的列可以排除。所以每进行一次大小的判断，都有一行或者一列被排除，
    //要比O（m * n）好很多
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int pivotR = 0, pivotC = n - 1;

        while(pivotR < m && pivotC >= 0){
            if(matrix[pivotR][pivotC] == target){
                return true;
            }else if(matrix[pivotR][pivotC] < target){
                pivotR++;
            }else{
                pivotC--;
            }
        }
        //Math.sqrt();
        return false;
    }
}
