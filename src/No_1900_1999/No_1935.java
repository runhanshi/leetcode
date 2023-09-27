package No_1900_1999;

import java.util.HashSet;
import java.util.Set;

// No.1935.Maximum Number of Words You Can Type
// https://leetcode.com/problems/maximum-number-of-words-you-can-type
public class No_1935 {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> letters = new HashSet<>();
        for(char b: brokenLetters.toCharArray()){
            letters.add(b);
        }
        int res = 0;
        for (String word: text.split(" ")){
            boolean find = false;
            for (char c: letters){
                if (word.indexOf(c) > -1) {
                    find = true;
                    break;
                }
            }
            if (!find) res++;
        }
        return res;
    }
}
