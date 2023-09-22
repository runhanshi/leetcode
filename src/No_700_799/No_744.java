package No_700_799;
// No.744.Find Smallest Letter Greater Than Target
// https://leetcode.com/problems/find-smallest-letter-greater-than-target
public class No_744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (letters[mid] == target){
                left = mid + 1;
            } else if (letters[mid] > target){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left < letters.length ? letters[left] : letters[0];
    }
}
