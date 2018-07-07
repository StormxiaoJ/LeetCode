class Solution {
    public String getPermutation(int n, int k) {
        if(n<=0){
            return "";
        }
        k--;
        StringBuilder result = new StringBuilder();
        int condition = 1;
        //比如当前长度是n，我们知道每个相同的起始元素对应(n-1)!
        //个permutation，也就是(n-1)!个permutation后会换一个起始元素。因此，只要当前的k进行(n-1)!取余
        for(int i = 1 ; i < n ; i++){
            condition *= i; 
        }

        List<Integer> number = new ArrayList<>();
        for(int i = 1 ; i <= n ;i++){
            number.add(i);    
        }
        int round = n - 1;
        while(round >= 0){
            int index = k/condition;
            k%=condition;
            result.append(number.get(index));
            number.remove(index);
            if(round>0){
                condition/=round;
            }
            round--;
        }
        return result.toString();
    }
}