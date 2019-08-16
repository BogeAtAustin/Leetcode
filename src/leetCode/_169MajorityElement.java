package leetCode;

public class _169MajorityElement {

//    Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
//    You may assume that the array is non-empty and the majority element always exist in the array.
//

    // More Voting.
    //这种投票法先将第一个数字假设为众数，然后把计数器设为1，比较下一个数和此数是否相等，若相等则计数器加一，反之减一。
    //然后看此时计数器的值，若为零，则将下一个值设为候选众数。以此类推直到遍历完整个数组，当前候选众数即为该数组的众数。
    //不仔细弄懂摩尔投票法的精髓的话，过一阵子还是会忘记的，首先要明确的是这个叼炸天的方法是有前提的，就是数组中一定要有众数的存在才能使用
    //因为只有众数存在，该投票法才能让这个数存留下来
        public int majorityElement(int[] nums) {
            int count = 0, candidate = nums[0];

            for(int num : nums){
                if(num == candidate){
                    count++;
                }else if(count == 0){
                    candidate = num;
                    count++;
                }else{
                    count--;
                }
            }
            return candidate;
        }

    //Bit manipulation
    //思路就是对每一个数的同一位进行统计，超过1/2的位（0/1）来组成结果的该位。32*n = O（n）
    public int majorityElement2(int[] nums) {
        int res = 0, n = nums.length;

        for(int i = 0; i < 32; i++){
            int ones = 0, zeros = 0;
            for(int num : nums){
                //reach the goal, no need to accumulate for this bit
                if(ones > n / 2 || zeros > n /2) break;
                //note 1: need () to include num & (1 << i). cuz != has higher priority
                //note 2: 不是==1， 而是不等于0，因为可能是 001， 010 etc.
                if((num & (1 << i)) != 0) ones++;
                else zeros++;
            }
            //default is zero
            if(ones > zeros){
                res |= (1 << i);
            }
        }
        return res;

    }
}
