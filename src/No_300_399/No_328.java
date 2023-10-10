package No_300_399;
// No.328.Odd Even Linked List
// https://leetcode.com/problems/odd-even-linked-list
public class No_328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tailOdd = head;
        ListNode tailEven = head.next;
        ListNode headEven = tailEven;
        while(tailEven != null && tailEven.next != null){
            tailOdd.next = tailEven.next;
            tailOdd = tailOdd.next;
            tailEven.next = tailOdd.next;
            tailEven = tailEven.next;
        }
        tailOdd.next = headEven;
        return head;
    }
}
