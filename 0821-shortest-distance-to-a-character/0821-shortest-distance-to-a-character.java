class Solution {
    public int[] shortestToChar(String s, char c) {

        int n = s.length();
        int[] answer = new int[n];
        int previous = -100000;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                previous = i;
            }
            answer[i] = i - previous;
        }

        int next = 100000;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                next = i;
            }
            answer[i] = Math.min(answer[i], next - i);
        }

        return answer;
    }
}