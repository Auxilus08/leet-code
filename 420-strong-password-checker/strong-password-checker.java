class Solution {
    public int strongPasswordChecker(String password) {
        int n = password.length();
        int missingTypes = 3;
        if (password.matches(".*[a-z].*")) missingTypes--;
        if (password.matches(".*[A-Z].*")) missingTypes--;
        if (password.matches(".*[0-9].*")) missingTypes--;

        int replace = 0;
        int oned = 0;
        int twod = 0; 

        for (int i = 2; i < n; i++) {
            if (password.charAt(i) == password.charAt(i - 1) && password.charAt(i - 1) == password.charAt(i - 2)) {
                int len = 2;
                while (i < n && password.charAt(i) == password.charAt(i - 1)) {
                    len++;
                    i++;
                }
                replace += len / 3;
                if (len % 3 == 0) oned++;
                else if (len % 3 == 1) twod++;
            }
        }

        if (n < 6) {
            return Math.max(6 - n, missingTypes);
        } else if (n <= 20) {
            return Math.max(replace, missingTypes);
        } else {
            int delete = n - 20;

            replace -= Math.min(delete, oned);

            int leftDelete = Math.max(0, delete - oned);
            replace -= Math.min(leftDelete, twod * 2) / 2;

            leftDelete = Math.max(0, leftDelete - twod * 2);
            replace -= leftDelete / 3;

            return delete + Math.max(replace, missingTypes);
        }
    }
}