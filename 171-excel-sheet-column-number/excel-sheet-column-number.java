class Solution {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        int pointer = columnTitle.length() - 1;

        for(int i = 0; i < columnTitle.length(); i++){
            int pos = columnTitle.charAt(i) - 'A' + 1;
            ans += (int) (pos * Math.pow(26, pointer));
            pointer--;
        }
        return ans;
    }
}