class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // swapping
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // aage badho
            prev = first;
        }

        return dummy.next;
    }
}