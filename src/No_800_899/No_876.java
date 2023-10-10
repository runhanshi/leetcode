package No_800_899;
// No.876.Middle of the Linked List
// https://leetcode.com/problems/middle-of-the-linked-list
public class No_876 {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
