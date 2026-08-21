class Solution {
    public long findKthSmallest(int[] coins, int k) {

        long left = 1;
        int minCoin = coins[0];

        for (int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }

        long right = (long) minCoin * k;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (count(mid, coins) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private long count(long x, int[] coins) {

        int n = coins.length;
        long result = 0;
        int totalMasks = 1 << n;

        for (int mask = 1; mask < totalMasks; mask++) {
            long lcm = 1;
            int bits = 0;
            boolean overflow = false;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;
                    lcm = lcm(lcm, coins[i]);

                    if (lcm > x) {
                        overflow = true;
                        break;
                    }
                }
            }

            if (overflow) {
                continue;
            }

            long current = x / lcm;

            if (bits % 2 == 1) {
                result += current;
            } else {
                result -= current;
            }
        }

        return result;
    }

    private long lcm(long a, long b) {

        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}