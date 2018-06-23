class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        
        if(n <= 0){
            return result;
        }
        
        int left = n;
        int right = n;
        
        helper(result,"",left,right);
        return result;
        
    }
    
    private void helper(ArrayList<String> result, String paren, int left, int right){
        //运用递归，将每次的半括号(删除之后补上新的情况
        //((()))
        //(()())
        //(())()
        //....
        if(left == 0 && right == 0){
            result.add(paren);
            return;
        }
        if(left > 0){
            helper(result,paren+"(",left-1,right);
        }
        if(right > 0 && left < right){
            helper(result, paren+")", left, right-1);
        }
    }
}