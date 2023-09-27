package No_700_799;


// No.725.Split Linked List in Parts
// https://leetcode.com/problems/split-linked-list-in-parts
public class No_725 {
    public ListNode[] splitListToParts(ListNode head, int k){
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            n++;
        }
        // width: 基础数
        int width = n / k;
        // remainder：前remainder个额外添加
        int remainder = n % k;
        ListNode[] res = new ListNode[k];
        curr = head;
        for (int i = 0; i < k; i++){
            head = curr;
            for (int j = 0; j < width + ((i < remainder) ? 1 : 0) - 1; j++){
                if (curr != null) {
                    curr = curr.next;
                }
            }
            if (curr != null){
                ListNode t = curr.next;
                curr.next = null;
                curr = t;
            }
            res[i] = head;
        }
        return res;
    }
}
