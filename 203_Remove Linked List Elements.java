/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        // set a dummy node at the head of list to make the previous head has the same situation with other nodes
        dummy.next = head;
        head = dummy;
        while(head.next != null){
            if(head.next.val == val){
                head.next = head.next.next;
            } else{
                head = head.next;
            }
        }
        return dummy.next;
    }
}