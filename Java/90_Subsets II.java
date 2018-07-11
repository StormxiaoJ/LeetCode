class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        List<Integer> sub = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,result,sub,0);
        return result;
    }
    
    private void helper(int[] nums, List<List<Integer>> result, List<Integer> sub, int start){
        result.add(new ArrayList(sub));
        for(int i = start ; i < nums.length; i++){
            if(i != start && nums[i] == nums[i-1]){
                continue;
            } else {
                sub.add(nums[i]);
                helper(nums, result, sub, i+1);
                sub.remove(sub.size()-1);
            }
        }
    }
}