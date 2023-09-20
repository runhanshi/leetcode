package No_400_499;
// No.424.Longest Repeating Character Replacement
// https://leetcode.com/problems/longest-repeating-character-replacement
public class No_424 {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int[] windowCharCount = new int[26];
        int windowMaxCount = 0;
        int res = 0;

        while(right < s.length()){
            windowCharCount[s.charAt(right) - 'A']++;
            windowMaxCount = Math.max(windowMaxCount, windowCharCount[s.charAt(right) - 'A']);
            right++;

            while(right - left - windowMaxCount > k){
                windowCharCount[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
