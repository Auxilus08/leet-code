/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        
        while (true) {
            ListNode curr = prev.next;
            // Check if there are at least k nodes left
            ListNode check = curr;
            int count = 0;
            while (check != null && count < k) {
                check = check.next;
                count++;
            }
            if (count < k) {
                break;
            }
            
            // Reverse the group of k nodes
            ListNode groupPrev = prev;
            ListNode groupNext = check;
            
            ListNode p = null;
            ListNode c = curr;
            for (int i = 0; i < k; i++) {
                ListNode next = c.next;
                c.next = p;
                p = c;
                c = next;
            }
            
            // Connect the reversed group
            groupPrev.next = p;
            curr.next = groupNext;
            
            // Move prev to the end of the reversed group
            prev = curr;
        }
        
        return dummy.next;
    }
}