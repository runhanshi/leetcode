package No_001_100;
// No.21.Merge Two Sorted Lists
// https://leetcode.com/problems/merge-two-sorted-lists/
public class No_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                res.next = list1;
                list1 = list1.next;
            } else {
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }
        if (list1 != null) {
            res.next = list1;
        }
        if (list2 != null){
            res.next = list2;
        }
        return dummy.next;

    }

}