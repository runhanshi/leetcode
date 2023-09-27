package No_300_399;

import java.util.ArrayDeque;
import java.util.Deque;

// No.394.Decode String
// https://leetcode.com/problems/decode-string
public class No_394 {
    public String decodeString(String s){
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<String> s2 = new ArrayDeque<>();
        String res = "";
        int num = 0;
        for (char c: s.toCharArray()){
            if ('0' <= c && c <= '9') {
                // num不一定是一位数
                num = num * 10 + (c - '0');
            } else if ( c == '[' ){
                s1.push(num);
                s2.push(res);
                num = 0;
                res = "";
            } else if ( c == ']' ) {
                StringBuilder sb = new StringBuilder();
                int repeatTimes = s1.isEmpty() ? 0 : s1.pop();
                for (int i = 0 ;i < repeatTimes; i++){
                    sb.append(res);
                }
                String prevString = s2.isEmpty() ? "" : s2.pop();
                res = prevString + sb.toString();
            } else {
                res += String.valueOf(c);
            }
        }
        return res;
    }
}
