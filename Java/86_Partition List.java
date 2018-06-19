/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }
        
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        //分成两个子链表最后接到一起
        
        ListNode left = leftDummy;
        ListNode right = rightDummy;
        
        while(head != null){
            if(head.val < x){
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }
        right.next = null;
        //大于的尾指向null
        left.next = rightDummy.next;
        //小于的尾指向第二个链表的有效部分（dummy head is useless）
        return leftDummy.next;
        
        
    }
}