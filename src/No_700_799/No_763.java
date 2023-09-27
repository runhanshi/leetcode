package No_700_799;

import java.util.ArrayList;
import java.util.List;

// No.763.Partition Labels
// https://leetcode.com/problems/partition-labels
public class No_763 {
    public List<Integer> partitionLabels(String s){
        int[] last = new int[26];
        int n = s.length();
        for (int i = 0; i < s.length(); i++){
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int mx = 0;
        int j = 0;
        for (int i = 0; i < n; i++){
            mx = Math.max(mx, last[s.charAt(i)]);
            if (i == mx) {
                res.add(i - j - 1);
                j = i + 1;
            }
        }
        return res;
    }
}
