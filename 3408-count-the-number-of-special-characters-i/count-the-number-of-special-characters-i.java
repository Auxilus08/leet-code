class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(char c : word.toCharArray()) {
            char opposite = (Character.isUpperCase(c)) ? Character.toLowerCase(c) : Character.toUpperCase(c);

            if(set.contains(opposite) && !set.contains(c)) {
                set.add(c);
                count++;
            }
            else {
                set.add(c);
            }
        }

        return count;
    }
}