class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int aliceSum = 0;
        int bobSum = 0;

        for (int x : aliceSizes) {
            aliceSum += x;
        }

        for (int x : bobSizes) {
            bobSum += x;
        }

        int diff = (aliceSum - bobSum) / 2;

        HashSet<Integer> bob = new HashSet<>();

        for (int x : bobSizes) {
            bob.add(x);
        }

        for (int x : aliceSizes) {
            int y = x - diff;

            if (bob.contains(y)) {
                return new int[]{x, y};
            }
        }

        return new int[0];
    }
}