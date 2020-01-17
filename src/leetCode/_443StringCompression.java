package leetCode;

public class _443StringCompression {

    /**
     * Given an array of characters, compress it in-place.
     *
     * The length after compression must always be smaller than or equal to the original array.
     *
     */
    //3 pointer method. 双指针不太好用，因为如果数组里每个元素只重复一次，slow需要把fast指向的元素替换，等于是fast指向的元素变了，会影响接下来的判断
    public int compress(char[] chars) {
        if(chars == null || chars.length == 0){
            return 0;
        }
        int write = 0, anchor = 0;
        for(int i = 0; i < chars.length; i++){
            if(i + 1 == chars.length || chars[i] != chars[i + 1]){
                chars[write] = chars[anchor];
                write++;
                if(i > anchor){
                    for(char c: ("" + (i - anchor + 1)).toCharArray()){
                        chars[write] = c;
                        write++;
                    }
                }
                anchor = i + 1;
            }
        }
        return write;
    }
}
