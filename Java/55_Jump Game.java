// dynamic programming version
class Solution {
    public boolean canJump(int[] nums) {
        boolean[] can = new boolean[nums.length];
        can[0] = true;
        for(int i =0; i<nums.length; i++){
            for(int j = 0 ; j < i; j++){
                if(can[j] && nums[j] + j >= i){
                    can[i] = true;
                    break;
                }
            }
        }
        return can[can.length-1];
    }
}
// greedy version
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 0 || nums == null){
            return false;
        }
        int farthest = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(i <= farthest && nums[i]+i >= farthest){
                farthest = nums[i] + i;
            }
        }
        return farthest >= nums.length-1;
    }
}