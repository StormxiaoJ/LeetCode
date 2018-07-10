class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        int res = 0;
        int count =1;
        for(int i = 1; i < nums.length; i++)
            if(nums[res] == nums[i]){
                if(count<2){
                    nums[++res] = nums[i];
                    count++;
                } 
                } else {
                    nums[++res] = nums[i];
                    count = 1;
            }
        return res+1;
    }
}