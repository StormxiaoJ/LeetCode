class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0){
            return result;
        }
        int[] dy = {1,0,-1,0};
        int[] dx = {0,1,0,-1};
        //用方向矩阵转方向 +1之后取余就可以跳转到下一个
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        boolean[][] visited = new boolean[r][c];
        int x =0, y=0, di=0;
        for(int i = 0 ; i < r*c ; i++){
            result.add(matrix[x][y]);
            visited[x][y] = true;
            int next_x = x+dx[di];
            int next_y = y+dy[di];
            if(next_x >=0 && next_y >=0 && next_x < r && next_y < c && !visited[next_x][next_y]){
                x = next_x;
                y = next_y;
            } else {
                di=(di+1)%4;
                x+=dx[di];
                y+=dy[di];
            }
        }
        return result;
        
        
    }
}