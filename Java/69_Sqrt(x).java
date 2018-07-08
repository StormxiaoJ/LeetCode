class Solution {
    public int mySqrt(int x) {
        if(x==0){
            return 0;
        }
        long start = 0;
        long end = x;
        while(start + 1 < end){
            long mid = start+(end - start)/2;
            if (mid*mid<= x && (mid+1)*(mid+1)>x){
                return (int)mid;
            } else if (mid*mid < x){
                start = mid;
            } else if (mid*mid >x){
                end = mid;
            }
        }
        if(start*start<= x && end*end> x){
            return (int)start;
        } else {
            return (int)end;
        }
    }
}