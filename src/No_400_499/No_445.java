package No_400_499;

import java.util.Stack;

// No.445 Add Two Numbers II
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class No_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        Stack<Integer> stk1 = new Stack<>();
        while(l1 != null) {
            stk1.push(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> stk2 = new Stack<>();
        while(l2 != null) {
            stk2.push(l2.val);
            l2 = l2.next;
        }

        ListNode dummy = new ListNode(-1);
        int carry = 0;
        while (carry > 0 || !stk1.isEmpty() || !stk2.isEmpty()){
            int val = carry;
            if (!stk1.isEmpty()) val += stk1.pop();
            if (!stk2.isEmpty()) val += stk2.pop();

            carry = val / 10;
            val = val % 10;
            ListNode curr = new ListNode(val);
            curr.next = dummy.next;
            dummy.next = curr;
        }
        return dummy.next;
    }

    // 用stack倒序存取，注意后面节点拼接顺序
}
