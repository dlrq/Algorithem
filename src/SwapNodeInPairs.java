public class SwapNodeInPairs {
        public ListNode swapPairs(ListNode head) {
            ListNode h = new ListNode(0);
            h.next = head;
            helper(h, head);
            return h.next;
        }

        public void helper(ListNode prev, ListNode head){
            if(head == null || head.next == null) return;
            ListNode next = head.next;
            head.next = head.next.next;
            next.next = head;
            prev.next = next;
            helper(head, head.next);
        }
}
