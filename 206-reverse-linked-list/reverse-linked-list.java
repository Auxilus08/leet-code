class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next; // store next node
            curr.next = prev;          // reverse the link
            prev = curr;               // move prev forward
            curr = temp;               // move curr forward
        }

        return prev;
    }
}
