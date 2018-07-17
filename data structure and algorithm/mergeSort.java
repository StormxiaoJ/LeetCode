public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        int[] temp = new int[A.length];
        mergeSort(A,0,A.length-1,temp);
    }
    
    private void mergeSort(int[] A, int start, int end, int[] temp){
        if(start >= end){
            return;
        }
        mergeSort(A,start,(start+end)/2, temp);
        mergeSort(A,(start+end)/2 + 1,end,temp);
        merge(A,start,end,temp);
    }
    
    private void merge(int []A, int start, int end, int[] temp){
        
        int mid = (start+end)/2;
        int i = start;
        int j = mid+1;
        int index = start;
    
        
        while(i<=mid && j<= end){
            if(A[i] < A[j]){
                temp[index++] = A[i++];
            } else {
                temp[index++] = A[j++];
            }
        }
        
        while (i <= mid){
            temp[index++] = A[i++];
        }
        
        while (j<= end){
            temp[index++] = A[j++];
        }
        
        for(int k = start ; k <= end; k++){
            A[k] = temp[k];
        }
    }
}