class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        //初始时用第一个string作为前缀，否则prefix始终为零
        String prefix = strs[0];
        for(int i=0; i<strs.length;i++){
            int j=0;
            while(j<prefix.length() && j<strs[i].length() && prefix.charAt(j) == strs[i].charAt(j)){
                j++;
            }
            prefix = prefix.substring(0,j);
        }
        return prefix;
        
    }
}