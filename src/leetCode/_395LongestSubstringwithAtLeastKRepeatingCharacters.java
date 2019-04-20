package leetCode;

public class _395LongestSubstringwithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] freq = new int[26];

        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        boolean flag = true;
        for(int num : freq){
            if(num > 0 && num < k){
                flag = false;
            }
        }
        if(flag == true){
            return s.length();
        }
        int start = 0, curr = 0, result = 0;
        while(curr < s.length()){
            if(freq[s.charAt(curr) - 'a'] < k){
                result = Math.max(result, longestSubstring(s.substring(start,curr), k));
                start = curr + 1;
            }
            curr++;
        }
        result = Math.max(result, longestSubstring(s.substring(start), k));
        return result;
    }
}
