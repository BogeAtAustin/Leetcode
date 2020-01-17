package leetCode;

public class _069SqrtX {

    public int mySqrt(int x) {

        if(x <= 1) return x;
        int start = 0, end = x;

        //can't handle x <=1
        //如果是start<end的话，会进入死循环[0,1,2],mid和start 永远都是1，1 < 2(end).
        while(start + 1 < end){
            int mid = (end - start) / 2 + start;
            //may overflow
            //int square = mid * mid;
            if(mid == x / mid){
                return mid;
            }else if(mid < x / mid){
                //如果mid + 1的话，可能会太大
                start = mid;
            }else{
                //如果mid - 1的话，可能会太小
                end = mid;
            }
        }
        return start;
    }
}
