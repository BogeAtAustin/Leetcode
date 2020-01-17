package leetCode;

public class _007ReverseInteger {

    public int reverse(int x) {
        if(x == 0) return x;
        boolean isNegative = false;
        if(x < 0){
            isNegative = true;
            x *= -1;
        }
        int range = 1;
        int temp = x;
        while(temp >= 10){
            temp = temp/10;
            range *= 10;
        }
        //using long, no double. also digit variable should declare as long too.cuz digit * range may overflow.
        long result = 0; long digit = 0;
        while(x > 0){
            digit = x % 10;
            result += digit * range;
            range /= 10;
            x /= 10;
        }

        if(result > Integer.MAX_VALUE){
            return 0;
        }
        if(isNegative == true){
            return -1 * (int) result;
        }else{
            return (int) result;
        }

    }
}
