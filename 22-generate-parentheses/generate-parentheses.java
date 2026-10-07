class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String curr, int open, int close, int n) {
        // base case: poori string ban gayi
        if (curr.length() == n * 2) {
            result.add(curr);
            return;
        }

        // open bracket laga sakte hai agar open < n
        if (open < n) {
            backtrack(result, curr + "(", open + 1, close, n);
        }

        // close bracket laga sakte hai agar close < open
        if (close < open) {
            backtrack(result, curr + ")", open, close + 1, n);
        }
    }
}