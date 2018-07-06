class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n == 0){
            return matrix;
        }
        
        int[] dx = {0,1,0,-1};
        int[] dy ={1,0,-1,0};
        
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < n;j++){
                matrix[i][j] = -1;
            }
        }
        int x=0,y=0,d=0;
        int next_x, next_y;
        for(int i = 1; i <= n*n ; ++i){
            matrix[x][y] = i;
            next_x = x + dx[d];
            next_y = y + dy[d];
            if(next_x<0 || next_y<0 || next_x>=n || next_y >=n || matrix[next_x][next_y] != -1){
                d = (d+1)%4;
                next_x = x + dx[d];
                next_y = y + dy[d];
            }
            x = next_x;
            y = next_y;
        }
        return matrix;
    }
}