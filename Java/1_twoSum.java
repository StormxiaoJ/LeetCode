class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if(nums == null || nums.length < 2){
            return new int[2];
        }
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.get(target - nums[i]) != null){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(nums[i], i );
            }
        }
        return null;
    }
}