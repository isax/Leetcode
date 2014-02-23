public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicatesElegant(int[] A) {
        if(A==null || A.length==0) return 0;
        
        int count = 0;
        for(int i = 1; i<A.length; i++){
            if(A[i]!=A[count]){
                count++;
                if(i!=count){
                    A[count] = A[i];
                }
            }
        }
        return count+1;
    }
}
