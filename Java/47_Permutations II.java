class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return results;
        }
        boolean[] visited = new boolean[nums.length];
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(nums);
        
        dfs(nums, visited, combination, results);
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
            
            if(i>0 && nums[i-1] == nums[i] && visited[i-1]){
            //这个visited[i-1]换成!visited[i-1]同样可以通过
                continue;
            }
            
            combination.add(nums[i]);
            visited[i] = true;
            dfs(nums,visited,combination,results);
            visited[i] = false;
            combination.remove(combination.size()-1);
            
        }
    }
}