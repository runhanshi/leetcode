package No_700_799;
// No.754.Reach a Number
// https://leetcode.com/problems/reach-a-number
public class No_754 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int step = 0;
        int start = 0;
        while(start < target || (start - target) % 2 != 0){
            step++;
            start += step;
        }
        return step;
    }
}
