class Solution {
    public int reverse(int x) {
        int reversed_x = 0;
        while(x != 0){
            int temp = reversed_x*10 + x%10;
            x = x / 10;
            if(temp/10 != reversed_x){
                reversed_x = 0;
                break;
            }
            reversed_x = temp;
        }
        return reversed_x;
        // res = res*10 + n%10 上一次的进一位，原数退一位
        // n = n/10
    }
}