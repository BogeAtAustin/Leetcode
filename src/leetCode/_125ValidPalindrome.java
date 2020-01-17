package leetCode;

public class _125ValidPalindrome {

    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     *
     * Note: For the purpose of this problem, we define empty string as valid palindrome.
     */

    public boolean isPalindrome(String s) {
        if(s == null) return false;
        if(s.isEmpty()) return true;
        String sl = s.toLowerCase();

        int start = 0, end = s.length() - 1;
        while(start < end){
            if(!Character.isLetterOrDigit(sl.charAt(start))){
                start++;
                continue;
            }
            if(!Character.isLetterOrDigit(sl.charAt(end))){
                end--;
                continue;
            }
            if(sl.charAt(start) != sl.charAt(end)){
                return false;
            }else{
                start++;
                end--;
            }
        }
        return true;
    }
}
