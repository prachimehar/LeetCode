class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int c = 0; 
        int currSum = 0;
        for(int i = 0; i< nums.length; i++){
            currSum += nums[i];
            int r = (currSum % k);

            if( r < 0){
            r += k;
            }
            
            if(map.containsKey(r)){
                c += map.get(r);
            }
            map.put(r , map.getOrDefault(r, 0)+1);
        }
        return c;
    }
}