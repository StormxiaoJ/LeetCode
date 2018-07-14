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
    List<Integer> nodeList = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        inorderTraverse(root);
        for(int i = 1; i<nodeList.size();i++){
            if(nodeList.get(i) <= nodeList.get(i-1)){
                return false;
            }
        }
        return true;
    }
    
    private void inorderTraverse(TreeNode root){
        if(root == null){
            return;
        }
        inorderTraverse(root.left);
        nodeList.add(root.val);
        inorderTraverse(root.right);
    }
}