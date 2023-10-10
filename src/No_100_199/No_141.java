package No_100_199;
// No.141.Linked List Cycle
// https://leetcode.com/problems/linked-list-cycle
public class No_141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
