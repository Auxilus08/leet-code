class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(char i : s.toCharArray()){
            if(i == '(' || i == '{' || i == '['){
                stk.push(i);
            }
            else if( !stk.isEmpty() && stk.peek() == '(' && i == ')'){
                stk.pop();
            }
            else if( !stk.isEmpty() && stk.peek() == '{' && i == '}'){
                stk.pop();
            }
            else if( !stk.isEmpty() && stk.peek() == '[' && i == ']'){
                stk.pop();
            }
            else {
                return false;
            }
        }

        return stk.isEmpty();
    }
}