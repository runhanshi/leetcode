package No_600_699;

import java.util.ArrayDeque;
import java.util.Deque;

// No.649.Dota2 Senate
// https://leetcode.com/problems/dota2-senate/
public class No_649 {
    public String predictPartyVictory(String senate){
        Deque<Integer> qr = new ArrayDeque<>();
        Deque<Integer> qd = new ArrayDeque<>();
        int n = senate.length();
        for (int i = 0; i < n; i++){
            if (senate.charAt(i) == 'R'){
                qr.offer(i);
            } else {
                qd.offer(i);
            }
        }

        while(!qr.isEmpty() && !qd.isEmpty()){
            if (qr.peek() < qd.peek()){
                qr.offer(qr.peek() + n);
            } else {
                qd.offer(qd.peek() + n);
            }
            qr.poll();
            qd.poll();
        }
        return qr.isEmpty() ? "Dire" : "Radiant";
    }
    // Time: O(n)
    // Space: O(n)
}
