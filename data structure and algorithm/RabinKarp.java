public class Solution{
	public int BASE =100000;
	public int strStr(String source, String target){
		if(source == null || target == null){
			return -1;
		}

		int m = target.length();
		if(m == 0){
			return 0;
		}
		// a* 31 ^ m
		int power =1;
		for(int i = 0 ; i < m ; i++){
			power = (power*31)%BASE;
		}

		int targetCode = 0;
		for(int i = 0; i < m ; i++){
			targetCode = (targetCode*31+target.charAt(i))%BASE;
		}

		int hashCode = 0;
		for(int i = 0; i < source.length(); i++){
			//abc+d
			hashCode = (hashCode*31 + source.charAt(i)) % BASE;
			if(i < m -1){
				continue;
			}
			//abcd-a
			if(i >= m){
				hashCode = hashCode - (source.charAt(i-m)*power)%BASE;
				if(hashCode < 0){
					hashCode += BASE;
				}
			}
			// double check the string

			if(hashCode == targetCode){
				if(source.substring(i-m+1,i+1).equals(target)){
					return i-m+1;

				}

			}

			//abcd - a

		}
		return -1;


	}
}