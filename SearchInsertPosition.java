public class SearchInsertPosition {
    public int searchInsertNaive(int[] A, int target) {
        if(A==null || A.length==0) return 0;
        
        if(target<=A[0]) return 0;
        for(int i = 0; i<A.length-1; i++){
            if(A[i]<target && A[i+1]>=target) return i+1;
        }
        return A.length;
    }
    
    /*
     * Binary Search
     * if 1 3 5 6 and target 2, end in left=right=0. then target>1, left = mid+1, return left=1 is correct.
     * if 1 3 5 6 and target 4, end in left=right=2. then target>5, right = mid-1, return left=2 is correct.
     * if 1 3 5 6 and target 0, end in left=right=0. then target<1, right = mid-1, return left=0 is correct.
     * if 1 3 5 6 and target 7, end in left=right=3. then target>6, left = mid+1, return left=4 is correct.
     */
    public int searchInsert(int[] A, int target) {
        
        return binarySearch(0, A.length-1, A, target);
    }
    
    public int binarySearch(int left, int right, int[] A, int target){
        if(left>right) return left;
        else{
            int mid = (left+right)/2;
            if(A[mid]==target){
                return mid;
            }else if(A[mid]>target){
                return binarySearch(left, mid-1, A, target);
            }else{
                return binarySearch(mid+1, right, A, target);
            }
        }
    }
}
