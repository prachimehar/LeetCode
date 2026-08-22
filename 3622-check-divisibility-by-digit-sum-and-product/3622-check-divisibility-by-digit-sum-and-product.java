class Solution {
    public boolean checkDivisibility(int n) {
        int temp = n;
        int sum = 0; 
        int mult = 1;
        while(temp > 0){
            int rem = temp%10;
            sum += rem;
            mult *= rem;
            temp = temp/10;
        }
        return (n % (sum + mult) == 0);
    }
}