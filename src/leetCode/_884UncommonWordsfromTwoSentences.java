package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _884UncommonWordsfromTwoSentences {

    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> map =new HashMap<>();
        String[] a = A.split(" ");
        String[] b = B.split(" ");

        for(String s : a){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for(String s : b){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> list = new ArrayList<>();
        for(Map.Entry entry : map.entrySet()){
            if((int)entry.getValue() == 1){
                // The way to utilize exist array to hold ingore the if the length is enough.
                //a[count] = (String)entry.getKey();
                list.add((String)entry.getKey());
            }
        }
        // List转Array的方法
        return list.toArray(new String[list.size()]);

    }
    //总结：为了节省创建新的中间数组翻了个车。原数组可能装不下新的数组
}
