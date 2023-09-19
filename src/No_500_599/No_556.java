package No_500_599;
// No.556.Next Greater Element III
// https://leetcode.com/problems/next-greater-element-iii
public class No_556 {
    public int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        // step1: 从右往左找第一个降序数字x
        int i = arr.length - 2;
        while(i >= 0 && arr[i + 1] <= arr[i]) i--;
        if (i < 0) return -1;

        // step2: 从右往左找第一个比x大的数字y
        int j = arr.length - 1;
        while(j >= 0 && arr[i] >= arr[j]) j--;

        // step3: 交换x和y
        swap(arr, i, j);

        // step4: 重新排列index_x + 1之后的
        reverse(arr, i + 1);
        long res = Long.parseLong(new String(arr));
        return res <= Integer.MAX_VALUE ? (int) res: -1;
    }

    private void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(char[] arr, int i){
        int end = arr.length - 1;
        int start = i;
        while(start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
