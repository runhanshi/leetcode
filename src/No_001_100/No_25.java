package No_001_100;
// No.25.Reverse Nodes in k-Group
// https://leetcode.com/problems/reverse-nodes-in-k-group
public class No_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode start = head;
        ListNode end = head;
        for (int i = 0; i < k; i++){
            if (end == null) return head;
            end = end.next;
        }
        ListNode newHead = reverse(start, end);
        start.next = reverseKGroup(end, k);
        return newHead;
    }

    private ListNode reverse(ListNode start, ListNode end){
        ListNode prev = null;
        ListNode curr = start;
        ListNode nxt = null;
        while (curr != end){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
}
