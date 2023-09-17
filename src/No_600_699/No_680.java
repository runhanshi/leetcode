package No_600_699;
// No.680.Valid Palindrome II
// https://leetcode.com/problems/valid-palindrome-ii/
public class No_680 {
    public boolean validPalindrome(String s) {
        if (s.length() == 1) return true;
        for (int i = 0, j = s.length() -1; i < j; i++, j--){
            if (s.charAt(i) != s.charAt(j)) {
                return check(s, i+ 1, j) || check(s, i, j - 1);
            }
        }
        return true;
    }

    private boolean check(String s, int i, int j){
        while(i < j){
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        // Error marker in 16/09/2023
        return true;
    }
}
