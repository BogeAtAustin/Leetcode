package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _049GroupAnagrams {

    /*  Anagram Definition
    Two words are anagrams of one another if their letters can be rearranged to form the other word. ...
    Note that all letters have been used, the substrings arecontiguous and their lengths are equal.
    Now you can change 'a' and 'b' in the first substring to 'd' and 'e' to have 'dec' and 'cde' which are anagrams.
    */

//    Given an array of strings, group anagrams together.
//
//            Example:
//
//    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//    Output:
//            [
//            ["ate","eat","tea"],
//            ["nat","tan"],
//            ["bat"]
//            ]

    public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> map = new HashMap();
            for(String str : strs){
                char[] ca = str.toCharArray();
                Arrays.sort(ca);
                String s = String.valueOf(ca);
                if(!map.containsKey(s)){
                    List<String> list = new ArrayList<>();
                    map.put(s, list);
                }
                map.get(s).add(str);
            }
            return new ArrayList(map.values());
    }
}
