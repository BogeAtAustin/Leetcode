package leetCode;

public class _004MedianOfTwoSortedArrays {

    /**
     * 题目要求Time log(m + n),就必须得用到二分法了
     * @param nums1
     * @param nums2
     * @return
     */


    //S0，能解决问题，但是达不到要求的Time Complexity. Merge to one array then find the median. Time O(m + n), space O(m + n)
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merge = new int[m + n];
        int i = 0, j = 0, k = 0;

        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                merge[k] = nums1[i];
                i++;
            }else{
                merge[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i < m){
            merge[k] = nums1[i];
            i++;
            k++;
        }
        while(j < n){
            merge[k] = nums2[j];
            j++;
            k++;
        }

        if((m + n) % 2 == 0){
            return ( (double)merge[(m + n) / 2 - 1] + (double)merge[(m + n) / 2]) / 2;
        }else{
            return (double)merge[(m + n) / 2];
        }
    }
}
