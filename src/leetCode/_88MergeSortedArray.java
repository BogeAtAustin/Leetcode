package leetCode;

public class _88MergeSortedArray {

    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    //基本功
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums2 == null ){
            return;
        }
        int i = nums1.length - 1, j = m - 1, k = n - 1;

        while(j >=0 && k >= 0){
            if(nums1[j] > nums2[k]){
                nums1[i] = nums1[j];
                j--;
            }else{
                nums1[i] = nums2[k];
                k--;
            }
            i--;
        }
        while(k >= 0){
            nums1[i--] = nums2[k];
            k--;
        }
        while(j >= 0){
            nums1[i--] = nums1[j];
            j--;
        }
    }
}
