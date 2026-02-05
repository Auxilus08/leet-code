class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int A[] = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            A[i] = nums[((((i + nums[i]) % n) + n) % n)];
        }


        return A;
    }
}