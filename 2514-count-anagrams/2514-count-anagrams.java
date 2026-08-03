class Solution {

    static final long MOD = 1_000_000_007L;

    public int countAnagrams(String s) {

        int n = s.length();
        long[] fact = new long[n + 1];
        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        long ans = 1;

        String[] words = s.split(" ");

        for (String word : words) {
            int[] freq = new int[26];

            for (char ch : word.toCharArray()) {
                freq[ch - 'a']++;
            }

            long ways = fact[word.length()];

            for (int count : freq) {
                if (count > 1) {
                    ways = ways * 
                           modInverse(fact[count]) 
                           % MOD;
                }
            }
            ans = ans * ways % MOD;
        }

        return (int) ans;
    }


    private long modInverse(long x) {
        return power(x, MOD - 2);
    }

    private long power(long a, long b) {
        long result = 1;

        while (b > 0) {

            if ((b & 1) == 1) {
                result = result * a % MOD;
            }

            a = a * a % MOD;

            b >>= 1;
        }

        return result;
    }
}