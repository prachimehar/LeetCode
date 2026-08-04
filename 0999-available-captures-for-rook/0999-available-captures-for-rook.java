class Solution {
    public int numRookCaptures(char[][] board) {
        int row = 0;
        int col = 0;

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j] == 'R'){
                    row = i;
                    col = j;
                }
            }
        }

        int count = 0;
        int[][] directions = {
            {-1,0}, 
            {1,0},  
            {0,-1}, 
            {0,1}  
        };

        for(int[] dir : directions){
            int r = row + dir[0];
            int c = col + dir[1];

            while(r >= 0 && r < 8 && c >= 0 && c < 8){
                if(board[r][c] == 'B'){
                    break;
                }
                if(board[r][c] == 'p'){
                    count++;
                    break;
                }
                r += dir[0];
                c += dir[1];
            }
        }

        return count;
    }
}