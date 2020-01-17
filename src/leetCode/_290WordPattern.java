package leetCode;

import java.util.HashMap;
import java.util.HashSet;

public class _290WordPattern {

    //Input: pattern = "abba", str = "dog cat cat dog"
    //Output: true

//    Input: pattern = "abba", str = "dog dog dog dog"
//    Output: false

    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        String[] strArray = str.split(" ");
        if(pattern.length() != strArray.length){
            return false;
        }

        for(int i = 0; i < pattern.length(); i++){
            if(!map.containsKey(pattern.charAt(i))){
                if(set.contains(strArray[i])){
                    return false;
                }
                map.put(pattern.charAt(i), strArray[i]);
                set.add(strArray[i]);
            }else{
                if(!map.get(pattern.charAt(i)).equals(strArray[i])){
                    return false;
                }
            }
        }
        return true;
    }

    //S2, 节省了hashset，利用containsValue（）
    public boolean wordPattern2(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        String[] strArray = str.split(" ");
        if(pattern.length() != strArray.length){
            return false;
        }

        for(int i = 0; i < pattern.length(); i++){
            if(!map.containsKey(pattern.charAt(i))){
                if(map.containsValue(strArray[i])){
                    return false;
                }
                map.put(pattern.charAt(i), strArray[i]);
            }else{
                if(!map.get(pattern.charAt(i)).equals(strArray[i])){
                    return false;
                }
            }
        }
        return true;
    }
}
