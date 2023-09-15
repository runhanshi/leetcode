package No_300_399;

import java.util.HashSet;
import java.util.Set;

// No.345.Reverse Vowels of a String
// https://leetcode.com/problems/reverse-vowels-of-a-string/
public class No_345 {
    public String reverseVowels(String s){
        String vowels = "aeiouAEIOU";
        Set<Character> vowelSet = new HashSet<>();
        for(int i = 0; i < vowels.length(); i++){
            vowelSet.add(vowels.charAt(i));
        }
        int left = 0;
        int right = s.length() - 1;
        char[] sArr = s.toCharArray();
        while (left < right){
            while(left < right && !vowelSet.contains(sArr[left])) left++;
            while(left < right && !vowelSet.contains(sArr[right])) right--;
            if (left < right) {
                char temp = sArr[left];
                sArr[left] = sArr[right];
                sArr[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(sArr);
    }
    // Time: O(n), n: the length of s
    // Space: O(|a|), a: the size of vowels
}
