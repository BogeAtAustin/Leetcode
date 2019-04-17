package leetCode;

import java.util.Arrays;

public class _977SquareOfASortedArray {
        public int[] sortedSquares1(int[] A) {
             //O(n) + O(logN)
             for(int i = 0; i < A.length; i++){
                 A[i] = A[i] * A[i];
             }
             Arrays.sort(A);
             return A;

//             for(int num : A){
//                 num = num * num;
//             }
        }
        public int[] sortedSquares2(int[] A) {
            // two pointer O(n)  Space O(n)
            int[] result = new int[A.length];
            int i = 0, j = A.length - 1, index = A.length - 1;
            while (i < j) {
                if (A[i] * A[i] < A[j] * A[j]) {
                    result[index--] = A[j] * A[j];
                    j--;
                } else {
                    result[index--] = A[i] * A[i];
                    i++;
                }
            }
            // Don't forget the one when i and j meet.
            // If i and j meet has value 0, then without this still return correct
            // result
            result[0] = A[i] * A[i];
            return result;
        }
}
