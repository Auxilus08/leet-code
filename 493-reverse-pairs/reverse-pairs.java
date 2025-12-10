class Solution {

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return mergeSortAndCount(nums, 0, nums.length - 1);
    }

    private int mergeSortAndCount(int[] arr, int start, int end) {
        if (start >= end) return 0;

        int mid = start + (end - start) / 2;

        int count = 0;
        count += mergeSortAndCount(arr, start, mid);
        count += mergeSortAndCount(arr, mid + 1, end);

        // Count reverse pairs
        int j = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (j <= end && (long) arr[i] > 2L * arr[j]) {
                j++;
            }
            count += j - (mid + 1);
        }

        // Merge the two sorted halves
        merge(arr, start, mid, end);

        return count;
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        // using predefined function System.arraycopy
        System.arraycopy(arr, start, left, 0, n1);
        System.arraycopy(arr, mid + 1, right, 0, n2);

        int i = 0, j = 0;
        int k = start;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < n1) {
            arr[k++] = left[i++];
        }

        while (j < n2) {
            arr[k++] = right[j++];
        }
    }
}
