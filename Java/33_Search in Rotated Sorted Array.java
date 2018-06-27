class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length ==0){
            return -1;
        }
        
        int start = 0;
        int end = nums.length-1;
        
        while(start + 1 < end){
            //注意等于的边界问题
            int mid = start + (end - start)/2;
            if(target == nums[mid]){
                return mid;
            }
            if (nums[start] < nums[mid]){
                if(nums[start] <= target && target <= nums[mid]){
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if(target >= nums[mid] && target <= nums[end]){
                    start = mid;
                } else {
                    end = mid;
                }
            }
            
        }
        if(target == nums[start]){
            return start;
        } else if (target == nums[end]){
            return end;
        } else {
            return -1;
        }
    }
}