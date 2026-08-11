class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {

        int[][] count = new int[10][10];
        int pairs = 0;

        for (int[] domino : dominoes) {
            int a = Math.min(domino[0], domino[1]);
            int b = Math.max(domino[0], domino[1]);

            pairs += count[a][b];
            count[a][b]++;
        }

        return pairs;
    }
}