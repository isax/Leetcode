public class SortColors {
    public void sortColorsTwoPass(int[] A) {
        int [] counts = new int[3];
        int length = A.length;
        for(int i = 0; i<length; i++){
            counts[A[i]]++;
        }
        for(int j = 0, index = 0; j<3; j++){
            while(counts[j]>0){
                A[index] = j;
                index++;
                counts[j]--;
            }
        }
    }
    /*
     * Reference Link: http://yucoding.blogspot.com/2013/05/leetcode-questions-99-sort-colors.html
     *
     * The goal is to rearrange the array, where 0s are in the 1st part of the array, 1s in the middle, and 2s are in the last. 
     * So,  we can just scan the whole array, when meet 0, put it in the front, when meet 2, put it in the last, and leave 1 alone thusin the middle. 
     * 0 and 2's positions are stored and modified each time a swap is performed.
     *
     */
    public void sortColors(int[] A) {
        int length = A.length;
        
        int red = 0; 
        int blue = length-1;
        int index = 0;
        
        while(index<=blue){ //0...red-1: all 0    blue-1...length-1:all 2
            if(A[index]==0){
                swap(A, index, red);
                red++;
                index++; 
            }
            else if(A[index]==2){
                swap(A, index, blue);
                blue--;
            }
            else index++;
        }
        
    }
    
    public void swap(int[]A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
