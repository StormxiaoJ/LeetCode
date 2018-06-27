class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return new int[]{-1,-1};
        }
        int start = 0;
        int end = nums.length -1;
        int[] result = new int[2];
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(target <= nums[mid]){
                end = mid;
                } else {
                start = mid;
                }
            }
        if(nums[start] == target){
            result[0] = start;
        } else if (nums[end] == target) {
            result[0] = end;             
        } else {
            result[0] = result[1] = -1;
        }
        start = 0;
        end = nums.length -1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(target < nums[mid]){
                end = mid;
            } else {
                start = mid;
            }
        }
        if(nums[end] == target){
            result[1] = end;
        } else if (nums[start] == target){
            result[1] = start;
        } else {
            result[0] = result[1] = -1;
        }
    return result;

    }
}