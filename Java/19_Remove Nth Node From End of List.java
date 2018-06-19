/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //快慢双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n < 0){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode delete = dummy;
        for(int i = 0; i < n; i++){
            if(head == null){
                return null;
            }
            head = head.next;
        }
        while(head != null){
            head = head.next;
            delete = delete.next;
        }
        delete.next = delete.next.next;
        return dummy.next;
    }
}