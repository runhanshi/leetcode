package No_400_499;
// No.459.Repeated Substring Pattern
// https://leetcode.com/problems/repeated-substring-pattern/
public class No_459 {
    public boolean repeatedSubstringPattern(String s){
        int n = s.length();
        for (int i = n / 2; i >= 1; i--){
            if (n % i == 0){
                int groupNum = n / i;
                String sub = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < groupNum; j++){
                    sb.append(sub);
                }
                if (sb.toString().equals(s)) return true;
            }
        }
        return false;
    }
}
