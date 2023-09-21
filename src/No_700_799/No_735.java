package No_700_799;

import java.util.ArrayDeque;
import java.util.Deque;

// No.735.Asteroid Collision
// https://leetcode.com/problems/asteroid-collision
public class No_735 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stk = new ArrayDeque<>();
        for (int x: asteroids){
            if (x > 0){
                stk.offerLast(x);
            } else {
                while(!stk.isEmpty() && stk.peek() < -x) {
                    stk.pop();
                }
                if (!stk.isEmpty() && stk.peekLast() < 0) {
                    stk.pollLast();
                } else if (stk.isEmpty() || stk.peekLast() < 0){
                    stk.offerLast(x);
                }
            }
        }
        return stk.stream().mapToInt(Integer:: valueOf).toArray();
    }
}
