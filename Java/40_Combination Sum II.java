class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return result;
        }
        
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, combination, target, result);
        return result;
    }
    
    private void helper(int[] candidates, int index, List<Integer> combination, int target, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<Integer>(combination));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(candidates[i] > target){
                break;
            }

            if(i != index && candidates[i] == candidates[i-1]){
                continue;
            }
            
            combination.add(candidates[i]);
            //与可重复不同的是从i+1开始
            helper(candidates, i+1, combination, target - candidates[i], result);
            combination.remove(combination.size() - 1);
        }
    }
}