package No_100_199;
// No.190.Reverse Bits
// https://leetcode.com/problems/reverse-bits/
public class No_190 {
    public int reverseBits(int n) {
        // 获取一个数字二进制表示的第k位
        // (x >> k) & 1
        // 将1 或 0 添加到x中的最后一位
        // (x << 1) | ( 1 or 0)
        int res = 0;
        for(int i = 0; i < 32; i++){
            res = (res << 1) | ((n >> i) & 1);
        }
        return res;
    }
}
