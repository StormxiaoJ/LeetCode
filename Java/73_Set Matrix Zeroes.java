class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length ==0){
            return;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        boolean f_row = false;
        boolean f_column = false;
        //先确定第一行第一列有没有0
        //用中间部分改变边界
        //用两个边界锁定中间
        for(int i = 0 ; i < rows ; i++){
            if(matrix[i][0] == 0){
                f_row = true;
                break;
            }
        }
        
        for(int j = 0 ; j < columns ; j++){
            if(matrix[0][j] == 0){
                f_column = true;
                break;
            }
        }
        
        for(int i = 1; i< rows; i++){
            for(int j = 1; j < columns; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = 1 ; i < rows; i++){
            for(int j = 1; j<columns; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(f_row){
            for(int i = 0 ; i < rows; i++){
                matrix[i][0] = 0;
            }
        }
        
        if(f_column){
            for(int j = 0; j < columns ; j++){
                matrix[0][j] = 0;
            }
        }
        
    }
}