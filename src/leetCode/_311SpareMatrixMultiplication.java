package leetCode;

import java.util.HashMap;

//Given two sparse matrices A and B, return the result of AB.
//
//You may assume that A's column number is equal to B's row number.
public class _311SpareMatrixMultiplication {

    public int[][] multiply(int[][] A, int[][] B) {

        if(A == null || B == null || A.length == 0 || B.length == 0 || A[0].length != B.length){
            return new int[A.length][B[0].length];
        }

        HashMap<Integer, int[]> rowInA = new HashMap<>();
        HashMap<Integer, int[]> colInB = new HashMap<>();

        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                if(A[i][j] != 0){
                    rowInA.put(i, A[i]);
                    break;
                }
            }
        }

        for(int j = 0; j < B[0].length; j++){
            for(int i = 0; i < B.length; i++){
                if(B[i][j] != 0){
                    int[] tmp = new int[B.length];
                    for(int k = 0; k < B.length; k++){
                        tmp[k] = B[k][j];
                    }
                    colInB.put(j, tmp);
                }
            }
        }

        int[][] res = new int[A.length][B[0].length];

        for(int i : rowInA.keySet()){
            for(int j : colInB.keySet()){
                for(int k = 0; k < A[0].length; k++){
                    res[i][j] += rowInA.get(i)[k] * colInB.get(j)[k];
                }
            }
        }
        return res;
    }

    public int[][] multiply2(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<A[i].length; j++) {
                if (A[i][j] == 0) continue;
                for(int k=0; k<B[0].length; k++) {
                    if (B[j][k] == 0) continue;
                    C[i][k] += A[i][j] * B[j][k];
                }
            }
        }
        return C;
    }
}
