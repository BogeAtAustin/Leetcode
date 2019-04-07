package leetCode;

public class _008StringToIntegerAtoi {
    public int myAtoi(String str){
        double result = 0;
        if(str == null){
            return 0;
        }
        //In case original str is " "
        str =str.trim();
        if(str.length() == 0){
            return 0;
        }
        int index = 0;
        char flag = '+';
        if(str.charAt(0) == '+'){
            index++;
        }else if(str.charAt(0) == '-'){
            index++;
            flag = '-';
        }

        while(index < str.length() && str.charAt(index) <= '9' && str.charAt(index) >= '0'){
            result = result * 10 + (str.charAt(index) - '0');
            index++;
        }

        if(result > Integer.MAX_VALUE) {
           if(flag == '+'){
               return Integer.MAX_VALUE;
           }else{
               return Integer.MIN_VALUE;
           }
        }

        if(flag == '-'){
            result *= -1;
        }

        return (int) result;
    }
}
