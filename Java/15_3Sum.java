class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //对撞双指针，helper函数写法蕾丝partition
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        for(int i=0; i< nums.length;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            } else {
                int target = -nums[i];
                int left = i+1;
                int right = nums.length-1;
                twoSum(nums,left,right,target,result);
            }
            
        }
        return result;
    }
    
    private void twoSum(int[] nums, int left, int right, int target, List<List<Integer>> result){
        while(left < right){
            
            if(nums[left] + nums[right] == target){
                List<Integer> sub = new ArrayList<>();
                sub.add(-target);
                sub.add(nums[left]);
                sub.add(nums[right]);
                left++;
                right--;
                result.add(sub);
                while(left < right && nums[left] == nums[left-1]){
                    left++;
                }
                while(left < right && nums[right] == nums[right+1]){
                    right--;
                }
            } else if(nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        
        }
    }
}