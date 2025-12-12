class Solution {
    public int[] searchRange(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;
        int mid;
        int[] ans = new int[]{-1, -1};

        while (low <= high) {
            mid = (low + high) / 2;

            if (target == nums[mid]) {
                int l = mid;
                while (l >= 0 && nums[l] == target) l--;
                ans[0] = l + 1;

                int r = mid;
                while (r < nums.length && nums[r] == target) r++;
                ans[1] = r - 1;
                break;
            }
            else if (target > nums[mid]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
