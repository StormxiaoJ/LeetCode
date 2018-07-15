public class Solution{
	public void sortIntegers(int[] A){
		for(int i = 0 ; i < A.length-1; i++){
			for(int j = 0 ; j< A.length; j++){
				if(A[i] > A[j]){
					int temp = A[i];
					A[i] = A[j];
					A[j] = temp;
				}
			}
		}
	}
}