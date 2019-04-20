package leetCode;

public class _925LongestPressedName {
    public boolean isLongPressedName(String name, String typed){
        if(typed == null || typed.length() == 0){
            return false;
        }
        if(typed.equals(name)){
            return true;
        }
        int index = 0, i = 0;

        while(index < name.length()){
            if(i == typed.length()){
                return false;
            }
            // no all not-equals returns false
            if(name.charAt(index) != typed.charAt(i)){
                if(i == 0 || typed.charAt(i - 1) != typed.charAt(i)){
                    return false;
                }
                char cur = typed.charAt(i);
                while((i < typed.length()) && (typed.charAt(i) == cur)){
                    i++;
                }
                if(i == typed.length() || typed.charAt(i) != name.charAt(index)){
                    return false;
                }
            }
            index++;
            i++;
        }
        return true;
    }
}
