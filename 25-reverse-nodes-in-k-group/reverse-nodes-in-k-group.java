class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // check karo k nodes hain bhi ya nahi
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }
        if (count < k) return head; // kam nodes bache toh reverse mat karo

        // ab k nodes ko reverse karo
        ListNode prev = null;
        ListNode next = null;
        curr = head;
        count = 0;
        while (count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // head ab last node ban gaya, uska next = baki list ka reversed head
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        return prev; // prev naya head hai
    }
}