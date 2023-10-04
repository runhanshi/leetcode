package No_800_899;
// No.845.Longest Mountain in Array
// https://leetcode.com/problems/longest-mountain-in-array
public class No_845 {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++){
            if (arr[i] > arr[i - 1]){
                left[i] = left[i - 1] + 1;
            }
        }

        for (int i = n - 2; i > 0; i--){
            if (arr[i] > arr[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++){
            if (left[i] > 0 && right[i] > 0) {
                res = Math.max(res, left[i] + right[i] + 1);
            }
        }
        return res;
    }
}
