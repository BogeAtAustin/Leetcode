package leetCode;

public class _167TwoSumII_InputArrayIsSorted {

    /**
     * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
     *
     * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
     */

    //two pointer / binary search, Time O(n)

    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0, index2 = numbers.length - 1;
        int[] result = new int[2];
        if(numbers == null || numbers.length < 2){
            return result;
        }

        while(index1 < index2){
            //use long to prevent temp overflow
            int temp = numbers[index1] + numbers[index2];
            if(temp == target){
                result[0] = index1 + 1;
                result[1] = index2 + 1;
                return result;
            }else if(temp < target){
                index1++;
            }else{
                index2--;
            }
        }
        return result;
    }
}
