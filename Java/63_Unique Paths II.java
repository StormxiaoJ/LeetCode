class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] path = new int[m][n];
        //如果在第一行或者第一列有障碍物，后面的绕都过不去了所以break
        for(int i = 0 ; i < m ; i++){
            if(obstacleGrid[i][0] != 1){
                path[i][0] = 1;
            } else {
                break;
            }
        }
        for(int j = 0; j<n;j++){
            if(obstacleGrid[0][j] != 1){
                path[0][j] = 1;
            } else {
                break;
            }
        }
        
        for(int i =1; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                if(obstacleGrid[i][j] != 1){
                    path[i][j] = path[i-1][j] + path[i][j-1];
                } else {
                    path[i][j] = 0;
                }
            }
        }
        return path[m-1][n-1];
        
    }
}