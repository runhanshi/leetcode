package No_600_699;

import java.util.LinkedList;
import java.util.List;

// No.658.Find K Closest Elements
// https://leetcode.com/problems/find-k-closest-elements/
public class No_658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x){
        int p = left_bound(arr, x);
        int left = p - 1;
        int right = p;
        LinkedList<Integer> res = new LinkedList<>();

        while (right - left - 1 > k){
            if (left == -1){
                res.addLast(arr[right]);
                right++;
            } else if (right == arr.length){
                res.addFirst(arr[left]);
                left--;
            } else if (x - arr[left] > arr[right] - x){
                res.addLast(arr[right]);
                right++;
            } else {
                res.addFirst(arr[left]);
                left--;
            }
        }
        return res;
    }

    private int left_bound(int[] arr, int x){
        int left = 0;
        int right = arr.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (arr[mid] == x){
                right = mid;
            } else if (arr[mid] > x){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
