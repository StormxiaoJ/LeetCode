class Solution {
    public String intToRoman(int num) {
        if(num <= 0){
            return "";
        }
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol= {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        int digital = 0;
        while(num>=0){
            int times = num/nums[digital];
            num-=times*nums[digital];
            for(;times>0;times--){
                res.append(symbol[digital]);
                
            }
            digital++;
        }
        return res.toString();
    }
}