class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, n = s.length();
        HashSet<Character> set = new HashSet<>();
        int maxl = 0;
        for(int right = 0; right < n; right++) {

            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxl = Math.max(maxl, set.size());
        }

        return maxl;
    }
}