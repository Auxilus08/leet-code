class Solution {
    int start = 0;  
    int maxLen = 0;
    public String longestPalindrome(String s) {
        for(int i =0; i < s.length(); i++){
            expand(s, i, i);
            expand(s, i, i + 1);
        }
        return s.substring(start, start + maxLen);
    }

    private void expand(String s, int l, int r){
        if(l < 0 || r >= s.length()) return;
        if(s.charAt(l) != s.charAt(r)) return;

        int len = r - l + 1;
        if(len > maxLen){
            maxLen = len;
            start = l;
        }


        expand(s, l - 1, r + 1);
    }
}