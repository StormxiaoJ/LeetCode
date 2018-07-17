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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        //stack的作用是用来颠倒顺序的
        queue.offer(root);
        int hight = 0;
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            if(hight%2 == 0){
                for(int i = 0; i < size ; i++){
                    TreeNode head = queue.poll();
                    level.add(head.val);
                    if(head.left != null){
                        stack.push(head.left);
                    }
                    if(head.right != null){
                        stack.push(head.right);
                    }
                }
                while(!stack.isEmpty()){
                    queue.offer(stack.pop());
                    //每一行的顺序都要换
                }
            }
            if(hight%2 == 1){
                for(int i = 0 ; i < size ; i++){
                    TreeNode head = queue.poll();
                    level.add(head.val);
                    if(head.right != null){
                        stack.push(head.right);
                    }
                    if(head.left != null){
                        stack.push(head.left);
                    }
                }
                 while(!stack.isEmpty()){
                    queue.offer(stack.pop());
                    //每一行的顺序都要换
                }
            }
            result.add(level);
            hight++;
            
        }
        return result;
    }
}