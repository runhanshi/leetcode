package No_700_799;

import java.util.PriorityQueue;

// No.767
// https://leetcode.com/problems/reorganize-string
public class No_767 {
    public String reorganizeString(String s) {
        int[] cnt = new int[26];
        int mx = 0;
        for (char c: s.toCharArray()){
            cnt[c - 'a']++;
            mx = Math.max(mx, cnt[c - 'a']);
        }

        int n = s.length();
        if (mx > (n + 1) / 2) return "";

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++){
            if (cnt[i] > 0){
                queue.offer(new int[]{cnt[i], i});
            }
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            // why need? s = aaabbc
            if (result.length() == 0 ||
                    result.charAt(result.length() - 1) != (char) ('a' + current[1])) {
                result.append((char) ('a' + current[1]));
                if (--current[0] > 0) {
                    queue.offer(current);
                }
            } else {
                int[] next = queue.poll();
                result.append((char) ('a' + next[1]));
                if (--next[0] > 0) {
                    queue.offer(next);
                }
                // 注意这里！
                queue.offer(current);
            }
        }
        return result.toString();
    }
}
