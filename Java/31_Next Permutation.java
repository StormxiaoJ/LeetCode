class Solution {
    public void nextPermutation(int[] nums) {
    //先从右往左找，发现第一个下降的数字，与从左往右数第一个比他大的数字互换
    //换到左边的那个数字之后全部反序
    // 1 ‘2’ 7 4 3 1
    // 1 2 7 4 ‘3’ 1
    // 1 ‘3’ 7 4 ‘2’ 1
    // 1 3 ‘1’ ‘2’ ‘4’ ‘7’
        int i = nums.length - 2;
        while(i>=0 && nums[i+1] <= nums[i]){
            i--;
        }
        if(i>=0){
            int j = nums.length -1;
            while( j>=0 && nums[j] <= nums[i]){
                j--;
            }
            swapItem(nums,i,j);
            
        }
        swapList(nums,i+1);
    }
    
    private void swapItem(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void swapList(int[] nums, int i){
        int j = nums.length-1;
        while(i < j){
            swapItem(nums, i, j);
            i++;
            j--;
        }
    }
}