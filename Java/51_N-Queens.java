class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n <= 0){
            return result;
        }
        search(result, new ArrayList<Integer>(), n);
        return result;
    }
    
    private void search(List<List<String>> result, List<Integer> cols, int n){
        if(cols.size() == n){
            result.add(drawChessboard(cols));
            return;
        }
        for(int colIndex = 0 ; colIndex < n ; colIndex++){
            if(!isValid(cols, colIndex)) {
                continue;
            }
            
            cols.add(colIndex);
            search(result,cols,n);
            cols.remove(cols.size()-1);
        }
    }
    
    private boolean isValid(List<Integer> cols, int column){
        int row = cols.size();
        //size决定了是在第几行放了皇后，cols.get()决定了在这行的第几列有皇后
        //新皇后的坐标可能为（row，column）
        for(int rowIndex = 0 ; rowIndex < row ; rowIndex++){
            if(cols.get(rowIndex) == column){
                //在此之前的行中该列有皇后
                return false;
            }
            if(cols.get(rowIndex)+rowIndex == row + column){
                return false;
            }
            if(cols.get(rowIndex)-rowIndex == column - row){
                return false;
            }
            
        }
        return true;
    }
    
    private List<String> drawChessboard(List<Integer> cols){
        List<String> chessboard = new ArrayList<>();
        for(int i = 0 ; i < cols.size(); i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < cols.size(); j ++){
                if(j == cols.get(i)){
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            chessboard.add(sb.toString());
        }
        return chessboard;
    }
    
    
}