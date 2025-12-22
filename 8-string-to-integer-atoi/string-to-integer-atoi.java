class Solution {
    public int myAtoi(String s) {
        if(s == null || s.length() == 0) return 0;

        int n = s.length();
        long res = 0;
        int i = 0;
        while(i < n && s.charAt(i) == ' ') i++;

        if(i == n) return 0;

        int sign = 1;
        if(s.charAt(i) == '+' || s.charAt(i) == '-'){
            if(s.charAt(i) == '-'){
                sign = -1;
            }
            i++;
        }
        while(i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            res = res * 10 + digit;
        

        if(Integer.MIN_VALUE > res * sign){
            return Integer.MIN_VALUE;
        }
        if(Integer.MAX_VALUE < res * sign){
            return Integer.MAX_VALUE;
        }
            i++;
        }

        return (int) res * sign;
    }
}