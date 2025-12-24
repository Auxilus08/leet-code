class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] result = new int[26];

        for (char c : s.toCharArray()) {
            result[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            result[c - 'a']--;
        }

        for (int i : result) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}