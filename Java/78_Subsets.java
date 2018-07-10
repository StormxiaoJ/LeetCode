class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length ==0){
            return result;
        }
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        helper(result,subset,0,nums);
        return result;
        
    }
    private void helper(List<List<Integer>> result, List<Integer> subset, int start,int[] nums){
        result.add(new ArrayList<>(subset));
        for(int i = start; i< nums.length; i++){
            subset.add(nums[i]);
            helper(result,subset,i+1,nums);
            subset.remove(subset.size()-1);
        }
    }
}