class Solution {
    ArrayList<String> strings = new ArrayList<>();
    public String getHappyString(int n, int k) {
        String currentString = "";
        generateStrings(n, currentString);

        if(strings.size() < k) return "";
        return strings.get(k - 1);
        
    }
    private void generateStrings(int n, String currentString) {
        if(currentString.length() == n) {
            strings.add(currentString);
            return;
        }

        for(char c = 'a'; c <= 'c'; c++) {
            if(currentString.length() > 0 && currentString.charAt(currentString.length() - 1) == c) continue;

            generateStrings(n, currentString + c);
        }
    }


}