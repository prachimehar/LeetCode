class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            if (col >= 2 && col <= 9) {
                int mask = map.getOrDefault(row, 0);
                mask |= 1 << (col - 2);
                map.put(row, mask);
            }
        }

        int answer = (n - map.size()) * 2;

        int left = 0b00001111;    
        int middle = 0b00111100;  
        int right = 0b11110000;   

       for (int mask : map.values()) {
            if ((mask & left) == 0 &&
                (mask & right) == 0) {
                answer += 2;
            }

            else if ((mask & left) == 0 ||
                     (mask & middle) == 0 ||
                     (mask & right) == 0) {

                answer += 1;
            }
        }

        return answer;
    }
}