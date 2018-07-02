class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return result;
        }
        
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,0,target,combination,result);
        
        return result;
    }
    
    private void helper(int[] candidates, int index, int target, List<Integer> combination, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<Integer>(combination));
            return;
        }
        
        for(int i = index; i < candidates.length; i++){
            if(candidates[i] > target){
                break;
            }
            
            if(i != 0 && candidates[i] == candidates[i-1]){
                continue;
            }
            
            combination.add(candidates[i]);
            helper(candidates, i, target - candidates[i], combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}