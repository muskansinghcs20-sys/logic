class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Min-Heap: sabse chota val wala node upar rahega
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // saari lists ke first node ko heap me daalo
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll(); // sabse chota nikala
            curr.next = smallest;
            curr = curr.next;

            if (smallest.next != null) {
                pq.add(smallest.next); // usi list ka next node daal do
            }
        }

        return dummy.next;
    }
}