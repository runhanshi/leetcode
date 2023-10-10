package No_900_999;

import java.util.PriorityQueue;
import java.util.Random;

// No.912.Sort an Array
// https://leetcode.com/problems/sort-an-array
public class No_912 {
    // Method_1: quick sort
    public int[] sortArray_QuickSort(int[] nums) {
        shuffle(nums);
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void shuffle(int[] nums){
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++){
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void quickSort(int[] nums, int start, int end){
        if (start >= end) return;
        int p = partition(nums, start, end);
        quickSort(nums, start, p - 1);
        quickSort(nums, p + 1, end);
    }

    private int partition(int[] nums, int lo, int hi){
        int pivot = nums[lo];
        int i = lo + 1;
        int j = hi;
        while (i <= j){
            while(i < hi && nums[i] <= pivot) i++;
            while(j > lo && nums[j] > pivot) j--;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    // Method_2: merge sort
    public int[] sortArray_MergeSort(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp){
        if (left < right){
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid, temp);
            mergeSort(nums, mid + 1, right, temp);
            merge(nums, left, mid, right, temp);
        }
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp){
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right){
            if (nums[i] <= nums[j]){
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right){
            temp[k++] = nums[j++];
        }
        for (k = left; k <= right; k++){
            nums[k] = temp[k];
        }
    }

}
