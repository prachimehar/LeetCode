class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int n : nums){
            min = Math.min(min,n);
            max = Math.max(max,n);
        }

        return GCD(min,max);
        
    }

    private int GCD(int a, int b){

        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    
}