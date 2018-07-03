class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return results;
        }
        
        dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), results);
        
        return results;
    }
    
    private void dfs(int[] nums, boolean[] visited, List<Integer> combination, List<List<Integer>> results){
        if(combination.size() == nums.length){
            results.add(new ArrayList<Integer>(combination));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            
            combination.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, combination, results);
            
            visited[i] = false;
            combination.remove(combination.size()-1);
        }
    }
}