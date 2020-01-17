package leetCode;

public class _014LongestCommonPrefix {

    //O(m * n)
    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();
        if(strs == null || strs.length == 0) return sb.toString();
        //length 初始化不是0
        int length = Integer.MAX_VALUE;
        for(String s : strs){
            length = Math.min(s.length(), length);
        }

        for(int i = 0; i < length; i++){
            for(int j = 0; j < strs.length - 1; j++){
                if(strs[j].charAt(i) != strs[j + 1].charAt(i)){
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }



        return sb.toString();
    }
}
