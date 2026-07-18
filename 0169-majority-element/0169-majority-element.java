class Solution {
    public int majorityElement(int[] nums) {

        int n = nums.length;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(e.getValue() > (n/2)){
                return e.getKey();
            }
        }
        return 0;
        
    }
}