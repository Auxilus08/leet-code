class Solution {
    private double power(double x, long n){
        if(n == 0) return 1;
        if(n == 1) return x;
        double half = power(x, n/2);
            if(n % 2 == 0){
                 return half * half;
            }
            else{
                return half * half * x;
            }
    }
    public double myPow(double x, int n) {
        long N = n;
        if(n < 0){
            return 1 / power(x, -1 * N);
        }
        return power(x, N);
    }
}