import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args){
        mergeKLists(null);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) return null;
        int k = lists.length;
        if(k == 0) return null;
        if(k == 1) return lists[0];
        ListNode head = new ListNode(Integer.MIN_VALUE);
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(k, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode cur = head;
        // 建堆
        for(ListNode p:lists){
            if(p != null){
                priorityQueue.add(p);
            }
        }
        while(!priorityQueue.isEmpty()){
            cur.next = priorityQueue.poll();
            cur = cur.next;
            if(cur.next != null) {
                priorityQueue.add(cur.next);
            }
        }
        return head.next;
    }
}
