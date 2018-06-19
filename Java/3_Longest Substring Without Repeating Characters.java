class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        int j = 0;
        int ans = 0;
        for(int i = 0; i < s.length();i++){
            while(j < s.length() && map[s.charAt(j)] ==0){
                ans = Math.max(ans, j-i+1);
                map[s.charAt(j)] = 1;
                j++;
            }
            map[s.charAt(i)] = 0;
            //当有重复的出现时，快指针更新的要被慢指针还原后再继续
        }
        return ans;
    }
}