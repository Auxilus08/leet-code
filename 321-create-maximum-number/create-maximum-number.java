class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - m); i <= Math.min(k, n); i++) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, ans, 0)) {
                ans = candidate;
            }
        }
        return ans;
    }

    private int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        int j = 0; 
        for (int i = 0; i < n; i++) {
            while (j > 0 && nums[i] > res[j - 1] && n - i > k - j) {
                j--;
            }
            if (j < k) {
                res[j++] = nums[i];
            }
        }
        return res;
    }

    private int[] merge(int[] a, int[] b, int k) {
        int[] res = new int[k];
        int i = 0, j = 0;
        for (int r = 0; r < k; r++) {
            res[r] = greater(a, i, b, j) ? a[i++] : b[j++];
        }
        return res;
    }

    private boolean greater(int[] a, int i, int[] b, int j) {
        while (i < a.length && j < b.length && a[i] == b[j]) {
            i++;
            j++;
        }
        return j == b.length || (i < a.length && a[i] > b[j]);
    }
}