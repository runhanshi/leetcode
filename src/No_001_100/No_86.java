package No_001_100;
// No.86.Partition List
// https://leetcode.com/problems/partition-list
public class No_86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode smallHead = new ListNode(-1);
        ListNode small = smallHead;
        ListNode bigHead = new ListNode(-1);
        ListNode big = bigHead;
        while(head != null){
            if (head.val < x){
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;
        small.next = bigHead.next;
        return smallHead.next;
    }
}
