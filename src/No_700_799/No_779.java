package No_700_799;
// No.779.K-th Symbol in Grammar
// https://leetcode.com/problems/k-th-symbol-in-grammar
public class No_779 {
    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        int len = (int)Math.pow(2, (n - 1));
        if (k <= len / 2){
            return kthGrammar(n - 1, k);
        }
        return kthGrammar(n - 1, k - len / 2) ^ 1;
    }
}
