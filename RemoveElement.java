public class RemoveElement {

	/*
	 * two pointers, one starts from left, the other one starts from right.
	 */
	public int removeElement(int[] A, int elem) {
            if(A==null||A.length == 0) return 0;
        
            int right = A.length - 1;
            int left = 0;
        
            while(left<right){
            	
                while(left<A.length&&A[left]!=elem) left++;
                while(right>0&&A[right]==elem) right--;
            
                if(left<right){
                        int temp = A[left];
                        A[left] = A[right];
                        A[right] = temp;
                        left++;
                        right--;
                }
            }
            int i = 0;
            while(i<A.length&&A[i]!=elem){
                i++;
            }
            return i;
        }
	
	/*
	 * Both pointers start from 0. Similar to 2.4 Partition List
	 */
	public int removeElementCleaner(int[] A, int elem) {

		if(A==null||A.length == 0) return 0;
		int l = 0;
		int r = 0;
		while(r<A.length){
        	if(A[r]!=elem){
        		A[l] = A[r];
        		l++;
        	}
        	r++;
        }
        return l;
	}
}
