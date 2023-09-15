package No_600_699;
// No.633.Sum of Square Numbers
// https://leetcode.com/problems/sum-of-square-numbers/
public class No_633 {
    public boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (long)Math.sqrt(c);
        while(left <= right){
            long cur = left * left + right * right;
            if (cur == c) {
                return true;
            } else if (cur > c){
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
