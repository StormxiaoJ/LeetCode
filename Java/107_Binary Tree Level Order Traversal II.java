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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> finalResult = new ArrayList<>();
        Stack<List<Integer>> result = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return finalResult;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode head = queue.poll();
                if(head != null){
                    level.add(head.val);
                }
                if(head.left != null){
                    queue.offer(head.left);
                }
                if(head.right != null){
                    queue.offer(head.right);
                }
            }
            result.push(level);
        }
        while(!result.isEmpty()){
            finalResult.add(result.pop());
        }
        return finalResult;
    }
}