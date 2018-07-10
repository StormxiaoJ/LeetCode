class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        
        int l = 0;
        int r = nums.length-1;
        int i = 0;
        //i代表指针进度，也表示1，l代表0，r代表2，如果nums【i】==2，和r指针交换，但是不确定换过来的是什么
        //所以i不往前走，得再检查一次
        
        while(i<=r){
            if(nums[i] == 0){
                swap(nums,i,l);
                i++;
                l++;
            } else if (nums[i] == 1){
                i++;
            } else {
                swap(nums,i,r);
                r--;
            }
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}