public class Solution{
	pulbic void sortIntegers(int[] A){
		while(true){
			boolean exchange = false;
			for(int i = 0; i < A.length-1 ; i++){
				if(A[i] > A[i+1]){
					int tmp = A[i];
					A[i+1] = tmp;
					exhcange = true;
				}
			}
			if(!exchange){
				break;
			}
		}
	}
}