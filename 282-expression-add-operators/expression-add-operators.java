class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) return result;
        backtrack(result, "", num, target, 0, 0, 0);
        return result;
    }

    private void backtrack(List<String> res, String path, String num, int target, int index, long eval, long prevMove) {
        if (index == num.length()) {
            if (eval == target) {
                res.add(path);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') break;

            String part = num.substring(index, i + 1);
            long curr = Long.parseLong(part);

            if (index == 0) {
                backtrack(res, path + part, num, target, i + 1, curr, curr);
            } else {
                backtrack(res, path + "+" + part, num, target, i + 1, eval + curr, curr);
                backtrack(res, path + "-" + part, num, target, i + 1, eval - curr, -curr);
                backtrack(res, path + "*" + part, num, target, i + 1, eval - prevMove + (prevMove * curr), prevMove * curr);
            }
        }
    }
}