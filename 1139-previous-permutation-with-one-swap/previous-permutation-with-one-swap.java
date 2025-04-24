class Solution {
    public int[] prevPermOpt1(int[] A) {
        if (A.length <= 1) return A;
        int idx = -1;
		
        for (int i = A.length - 1; i >= 1; i--) {
            if (A[i] < A[i - 1]) {
                idx = i - 1;
                break;
            }
        }
		
        if (idx == -1) return A;
		
        for (int i = A.length - 1; i > idx; i--) {
			
            if (A[i] < A[idx] && A[i] != A[i - 1]) {
                int tmp = A[i];
                A[i] = A[idx];
                A[idx] = tmp;
                break;
            }
        }
        return A;
    }
}