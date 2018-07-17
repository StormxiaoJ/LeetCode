public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        quickSort(A,0,A.length-1);
    }
    private void quickSort(int[] A,int start,int end){
        if(start >= end){
            return;
        }
        int i = start;
        int j = end;
        int pivot = A[(start+end)/2];
        while(i <= j){
            while(i<=j && A[i]<pivot){
                i++;
            }
            while(i<=j && A[j]>pivot){
                j--;
            }
            if(i<=j){
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
                j--;
            }
        }
        quickSort(A,start,j);
        quickSort(A,i,end);
    }
}