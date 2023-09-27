package No_700_799;

import java.util.HashSet;
import java.util.Set;

// No.771.Jewels and Stones
// https://leetcode.com/problems/jewels-and-stones
public class No_771 {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewel = new HashSet<>();
        for(char j: jewels.toCharArray()){
            jewel.add(j);
        }
        int res = 0;
        for (int i = 0; i < stones.length(); i++){
            if (jewel.contains(stones.charAt(i))) res++;
        }
        return res;
    }
}
