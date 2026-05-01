class Solution {
    public int trap(int[] height) {

        int l = 0, r = height.length - 1;
        int total = 0;
        int leftMax = 0, rightMax = 0;
        
        while(l < r){
            if(height[l] > leftMax){
                leftMax = Math.max(leftMax, height[l]);
            }
            else if(height[r] > rightMax){
                rightMax = Math.max(rightMax, height[r]);
            }
            else if(leftMax < rightMax){
                total += leftMax - height[l];
                l++;
            }
            else{
                total += rightMax - height[r];
                r--;
            }
        }

        return total;

    }
}