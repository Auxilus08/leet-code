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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0 || k % getLength(head) == 0) return head;

        int length = getLength(head);

        k = k % length;
        ListNode slow = head;
        ListNode fast = head;

        for(int i = 0; i < k; i++){
            fast = fast.next;
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        ListNode newNode = slow.next;
        slow.next = null;
        fast.next = head;



        return newNode;
    }


    private static int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while(current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
}