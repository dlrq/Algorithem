public class ReorderList{
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        reorderList.reorderList(head);
    }

    public void reorderList(ListNode head) {
        ListNode h = new ListNode();
        ListNode cur = head;
        
        int size = 0;
        while(cur != null){
            size++;
            cur = cur.next;
        }
        
        int half = (size & 1) == 0 ? size/2 : size/2 + 1;
        
        cur = head;
        int cnt = 1;
        while(cnt < half){
            cnt++;
            cur = cur.next;
        }
        
        ListNode last = cur.next; 
        cur.next = null;
        while(last != null){
            ListNode tmp = h.next;
            h.next = last;
            last = last.next;
            h.next.next = tmp;
        }
        
        ListNode h1 = head;
        ListNode h2 = h.next;
        while(h1 != null && h2 != null){
            ListNode tmp = h1.next;
            h1.next = h2;
            h2 = h2.next;
            h1.next.next = tmp;
            h1 = tmp;
        }
    }
}