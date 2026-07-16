class Solution {
    public int minimumOperations(int[] nums) {
       int start = 0;
        int operations = 0;

        while (true) {

            HashSet<Integer> set = new HashSet<>();
            boolean unique = true;

            for (int i = start; i < nums.length; i++) {
                if (!set.add(nums[i])) {
                    unique = false;
                    break;
                }
            }

            if (unique) {
                return operations;
            }

            start += 3;
            operations++;
        }
    }
}