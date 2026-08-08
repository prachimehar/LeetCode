class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();
        int[] suff = new int[n + 1];
        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            suff[i] = suff[i + 1];

            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                suff[i]++;
                j--;
            }
        }

        int[] ans = new int[m];
        int p = 0;
        boolean usedMismatch = false;

        for (int i = 0; i < m; i++) {
            while (p < n) {
                if (word1.charAt(p) == word2.charAt(i)) {
                    ans[i] = p;
                    p++;
                    break;
                }

                if (!usedMismatch) {
                    int remaining = m - i - 1;
                    if (suff[p + 1] >= remaining) {
                        ans[i] = p;
                        p++;
                        usedMismatch = true;
                        break;
                    }
                }
                p++;
            }

            if (p == n && i != m - 1) {
                return new int[0];
            }

            if (i == m - 1 && p > n) {
                return new int[0];
            }
        }
        return ans;
    }
}