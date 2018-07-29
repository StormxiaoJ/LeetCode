class Solution {
    int result = 0 ;
    public int totalNQueens(int n) {
         
        if(n <= 0){
            return 0;
        }
        search(new ArrayList<Integer>(), n);
        return result;
    }
    
    private void search(List<Integer> cols, int n){
        if(cols.size() == n){
            result++;
            return;
        }
        for(int colIndex = 0 ; colIndex < n ; colIndex++){
            if(!isValid(cols, colIndex)){
                continue;
            }
            cols.add(colIndex);
            search(cols,n);
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
}