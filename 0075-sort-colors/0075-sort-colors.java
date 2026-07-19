class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        while(low <= high){
            if(nums[low] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            else if(nums[low] == 1){
                low++;
            }
            else{
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
        
    }
}