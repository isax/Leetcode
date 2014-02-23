public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] A) {
        if(A==null ||A.length==0) return 0;
        
        int index = 0;
        int count = 1;
        
        for(int i = 1; i<A.length; i++){
            if(A[i]!=A[index]){
                index++;
                A[index] = A[i];
                count = 1;
            }else{
                if(count==1){
                    index++;
                    A[index] = A[i];
                    count++;
                }
            }
        }
        return index+1;
    }
}
