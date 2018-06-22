class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //和3sum一样，多了一层循环，同为对撞型双指针
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length<4){
            return result;
        }
        Arrays.sort(nums);
        for(int i=0; i<nums.length;i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j=i+1; j<nums.length;j++){
                if(j != i+1 && nums[j] == nums[j-1]){
                    continue;              
                }
                int left = j+1;
                int right = nums.length-1;
                while(left < right){
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum < target){
                        left++;
                    }
                    else if(sum > target){
                        right--;
                    } else {
                        List<Integer> sub =new ArrayList<>();
                        sub.add(nums[i]);
                        sub.add(nums[j]);
                        sub.add(nums[left]);
                        sub.add(nums[right]);
                        result.add(sub);
                        left++;
                        right--;
                        while(left < right && nums[left-1] == nums[left]){
                        left++;
                    }
                        while(left < right && nums[right] == nums[right+1]){
                        right--;
                    }
                    }              
                }
            }
            
        }
        return result;
    }
}