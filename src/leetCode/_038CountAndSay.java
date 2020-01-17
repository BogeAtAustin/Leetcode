package leetCode;

public class _038CountAndSay {

    public String countAndSay(int n) {
        StringBuffer sb = new StringBuffer("1");
        int prev = 0;
        int count = 1;

        for(int i = 1; i < n; i++){
            prev = 0;
            StringBuffer say = new StringBuffer();
            count = 1;
            for(int j = 1; j < sb.length(); j++){
                if(sb.charAt(j) == sb.charAt(prev)){
                    count++;
                }else{
                    say.append(count).append(sb.charAt(prev));
                    count = 1;
                    prev = j;
                }
            }
            say.append(count).append(sb.charAt(prev));
            sb = say;
        }
        return sb.toString();
    }
}
