/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        helper(result,solution,root,sum);
        return result;
    }
    private void helper(List<List<Integer>> result, List<Integer> solution, TreeNode root,  int sum){
        if(root == null){
            return;
        }
        sum -= root.val;
        if(root.left == null && root.right == null){
            if(sum == 0){
                solution.add(root.val);
                result.add(new ArrayList<>(solution));
                solution.remove(solution.size()-1);
            }
            return;
        }
        solution.add(root.val);
        helper(result,solution,root.left,sum);
        helper(result,solution,root.right,sum);
        solution.remove(solution.size()-1);
    }
}