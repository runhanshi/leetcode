package No_400_499;
// No.443 String Compression
public class No_443 {
    public int compress(char[] chars) {
        int k = 0;
        int n = chars.length;
        for (int i = 0, j = i + 1; i < n; ) {
            while (j < n && chars[j] == chars[i]) j++;
            chars[k++] = chars[i];
            if (j - i > 1) {
                String cnt = String.valueOf(j - i);
                for (char c : cnt.toCharArray()) {
                    chars[k++] = c;
                }
            }
            i = j;
        }
        return k;
    }
}
