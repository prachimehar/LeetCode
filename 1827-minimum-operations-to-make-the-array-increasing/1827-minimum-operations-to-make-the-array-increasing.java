class Solution {
    public int minOperations(int[] nums) {
        int moves = 0;
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= max){
                moves += max + 1 - nums[i];
                nums[i] = max + 1;
                max = nums[i];
            }
            else{
                max = nums[i];
            }
        }
        return moves;
    }
}