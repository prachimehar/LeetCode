class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> answer = new ArrayList<>();
        generate("", 2 * n, answer);
        return answer;
    }

    private void generate(String current, int length, List<String> answer) {

        if (current.length() == length) {
            if (isValid(current)) {
                answer.add(current);
            }
            return;
        }

        generate(current + "(", length, answer);
        generate(current + ")", length, answer);
    }

    private boolean isValid(String s) {
        int balance = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                balance++;
            } else {
                balance--;
            }

            if (balance < 0) {
                return false;
            }
        }

        return balance == 0;
    }
}