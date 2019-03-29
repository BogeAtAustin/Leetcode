package leetCode;

import java.util.ArrayList;
import java.util.List;

public class _1002FindCommonCharacters {
//    Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
//
//    You may return the answer in any order.
//
//
//
//            Example 1:
//
//    Input: ["bella","label","roller"]
//    Output: ["e","l","l"]
//    Example 2:
//
//    Input: ["cool","lock","cook"]
//    Output: ["c","o"]

    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        int[] global = new int[26];
        int[] local = new int[26];

        for(int i = 0; i < 26; i++){
            global[i] = 101;
        }

        for(String s : A){
            for(int i = 0; i < 26; i++){
                local[i] = 0;
            }
            for(int i = 0; i < s.length(); i++){
                int position = (int)(s.charAt(i) - 'a');
                local[position]++;
            }
            for(int i = 0; i< 26; i++){
                global[i] = Math.min(global[i], local[i]);
            }
        }

        for(int i = 0; i < 26; i++){
            if(global[i] > 0){
                addToList(result, global[i], i);
            }
        }
        return result;
    }

    private void addToList(List<String> list, int count, int position){
        char candidate = (char)('a' + position);
        while(count > 0){
            StringBuilder sb = new StringBuilder();
            sb.append(candidate);
            list.add(sb.toString());
            count--;
        }
    }
}
