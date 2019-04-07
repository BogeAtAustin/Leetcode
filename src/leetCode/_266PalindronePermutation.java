package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class _266PalindronePermutation {

    //Given a string, determine if a permutation of the string could form a palindrome.


    public boolean canPermutePalindrome1(String s) {
        HashSet<Character> set = new HashSet<>();

        for(char c : s.toCharArray()){
            if(!set.contains(c)){
                set.add(c);
            }else{
                set.remove(c);
            }
        }
        if(s.length() % 2 == 0){
            if(set.isEmpty()){
                return true;
            }else{
                return false;
            }
        }else{
            if(set.isEmpty()){
                return false;
            }else{
                return set.size() == 1 ? true : false;
            }
        }
    }

    public boolean canPermutePalindrome2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int oddCount = 0;
        for(Map.Entry entry : map.entrySet()){
            if((int)entry.getValue() % 2 != 0){
                oddCount++;
            }
        }
        if(oddCount > 1){
            return false;
        }
        return true;
    }
}
