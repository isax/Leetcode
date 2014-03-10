public class NextPermutation {
    public void nextPermutation(int[] num) {
        int length = num.length;
        int partion = length-2;
        while(partion>=0 && num[partion]>=num[partion+1]){
            partion--;
        }
        
        if(partion>=0){
             int changeIndex = length-1;
             while(changeIndex>=partion+1 && num[partion]>=num[changeIndex]){
                 changeIndex--;
             }
             swap(num, partion, changeIndex);
        }
        
        //reverse partion+1 to the end
        int left = partion+1;
        int right = length-1;
        while(left<right){
            swap(num, left, right);
            left++;
            right--;
        }
    }
    
    public void swap(int[]num, int left, int right){
        int temp = num[left];
        num[left] = num[right];
        num[right] = temp;
    }
}
