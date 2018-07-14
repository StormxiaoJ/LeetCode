/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        int res = n-m+1;
        dummy.next = head;
        head = dummy;
        for(int i = 0; i < n; i++){
            head = head.next;
        }
        ListNode right = head;
        ListNode restart = head.next;
        
        head = dummy;
        for(int i = 0 ; i < m-1 ; i++){
            head = head.next;
        }
        
        ListNode left = head.next;
        
        ListNode prev = restart;
        
        for(int i = 0 ; i < res; i++){
            ListNode temp = left.next;
            left.next = prev;
            prev = left;
            left = temp;
        }
        head.next = right;
        System.out.println(head.val);
        return dummy.next;
        
        
        
        
    }
}