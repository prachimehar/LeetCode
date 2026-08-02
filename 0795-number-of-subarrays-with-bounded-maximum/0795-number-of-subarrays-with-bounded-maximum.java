class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int lastInvalid = -1;
        int lastValid = -1;

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > right)
                lastInvalid = i;

            if (nums[i] >= left && nums[i] <= right)
                lastValid = i;

            ans += Math.max(0, lastValid - lastInvalid);
        }

        return ans;
    }
}