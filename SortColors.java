public class SortColors {
    public void sortColors(int[] A) {
        int [] counts = new int[3];
        int length = A.length;
        for(int i = 0; i<length; i++){
            counts[A[i]]++;
        }
        for(int j = 0, index = 0; j<3; j++){
            int count = 0;
            while(count<counts[j]){
                A[index] = j;
                index++;
                count++;
            }
        }
    }
}
