class Solution {
    public String addBinary(String a, String b) {
        String res ="";
        int pa = a.length()-1;
        int pb = b.length()-1;
        int carry = 0;
        while(pa>=0 && pb>=0){
            int sum = (int)(a.charAt(pa) - '0') + (int)(b.charAt(pb) - '0') + carry;
            res = String.valueOf(sum%2) + res;
            carry = sum/2;
            pa--;
            pb--;
        }
        
        while(pa>=0){
            int sum = (int)(a.charAt(pa) - '0') + carry;
            res = String.valueOf(sum%2) + res;
            carry = sum/2;
            pa--;
        }
        
        while(pb>=0){
            int sum = (int)(b.charAt(pb) - '0') +carry;
            res = String.valueOf(sum%2) + res;
            carry = sum/2;
            pb--;
        }
        
        if(carry == 1){
            res = "1" + res;
        }
        return res;
    }
}