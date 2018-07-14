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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<TreeNode>();
        }
        return generate(1,n);
    }
    
    private List<TreeNode> generate(int start, int end){
        List<TreeNode> solution = new ArrayList<>();
        if(start>end){
            solution.add(null);
            return solution;
        }
        for(int i = start; i <= end ; i++){
            List<TreeNode> left = generate(start,i-1);
            //数组index小于i的在左子树
            List<TreeNode> right = generate(i+1,end);
            //数组index大于i的在右子数
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    solution.add(root);
                }
            }
        }
        return solution;
    }
}