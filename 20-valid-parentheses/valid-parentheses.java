import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 == 1) return false;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            char a = s.charAt(i);

            if (a == '(' || a == '[' || a == '{') {
                stack.push(a);
            } else {
                if (stack.empty()) return false;

                char m = stack.pop();
                if ((m == '[' && a != ']') ||
                    (m == '{' && a != '}') ||
                    (m == '(' && a != ')')) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
