class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3){
            return -1;
        }
        int res = nums[0]+nums[1]+nums[2];
        //res = Integer.MAX_VALUE;为什么不行
        Arrays.sort(nums);
        for(int i =0; i < nums.length; i++){
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target - sum) < Math.abs(target - res)){
                    
                    res = sum;
                    System.out.print(res);
                    
                }
                if(sum < target){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}