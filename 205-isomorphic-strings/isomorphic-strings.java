class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> sCharIndex = new HashMap<>();
        HashMap<Character, Integer> tCharIndex = new HashMap<>();

        for( int i = 0; i < s.length(); i++){
            if(!sCharIndex.containsKey(s.charAt(i))) sCharIndex.put(s.charAt(i), i);

            if(!tCharIndex.containsKey(t.charAt(i))) tCharIndex.put(t.charAt(i), i);

            if(!(sCharIndex.get(s.charAt(i)).equals(tCharIndex.get(t.charAt(i)))) ) return false;
        }
    
        return true;
    }
}