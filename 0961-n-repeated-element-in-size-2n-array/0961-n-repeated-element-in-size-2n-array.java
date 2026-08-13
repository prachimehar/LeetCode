class Solution {
    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> count = new HashMap();
        for (int n : A) {
            count.put(n , count.getOrDefault(n, 0) + 1);
        }

        for (int n : count.keySet())
            if (count.get(n) > 1)
                return n;

        throw null;
    }
}