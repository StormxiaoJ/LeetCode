class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
            return null;
        }
        int carry = 1;
        for(int i = digits.length-1; i >=0 ; i--){
            int sum = carry + digits[i];
            digits[i] = sum%10;
            carry = sum/10;
        }
        if(carry == 0){
            return digits;
        }
        int[] new_digits = new int[digits.length+1];
        new_digits[0] = carry;
        for(int i = 1; i < new_digits.length; i++){
            new_digits[i] = digits[i-1];
        }
        return new_digits;
    }
}