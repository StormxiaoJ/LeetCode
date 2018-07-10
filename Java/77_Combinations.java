class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        helper(result, solution, k, 1, n);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> solution, int k, int start, int end){
        if(solution.size() == k){
            result.add(new ArrayList<>(solution));
            return;
        }
        for(int i = start ; i <= end; i++){
            solution.add(i);
            helper(result, solution, k, i+1, end);
            solution.remove(solution.size()-1);
        }
    }
}