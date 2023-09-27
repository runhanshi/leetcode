package No_001_100;
// No.69.Sqrt(x)
// https://leetcode.com/problems/sqrtx
public class No_69 {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int left = 1;
        int right = x / 2;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (x / mid == mid) {
                return mid;
            } else if (x / mid > mid){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
