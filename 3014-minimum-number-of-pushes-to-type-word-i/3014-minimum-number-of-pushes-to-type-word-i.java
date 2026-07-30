class Solution {
    public int minimumPushes(String word) {
        
        int n = word.length();
        int pushes = 0;
        int cost = 1;

        for (int i = 0; i < n; i++) {
            if (i % 8 == 0 && i != 0) {
                cost++;
            }
            pushes += cost;
        }

        return pushes;
    }
}