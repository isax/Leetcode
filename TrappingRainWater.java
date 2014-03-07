public class TrappingRainWater {
    public int trap(int[] A) {
        if(A.length==0) return 0;
        
        int length = A.length;
        int [] l = new int[length];
        int [] r = new int[length];
        
        int max = A[0];
        l[0] = A[0];
        for(int i = 1; i<length; i++){
            if(A[i]>max){
                max = A[i];
            }
            l[i] = max;
        }
        
        //max = A[length-1];
        r[length-1] = A[length-1];
        //DP
        for(int i = length-2; i>=0; i--){
            r[i] = Math.max(A[i], r[i+1]);
        }
        /*
        for(int i = length-2; i>=0; i--){
            if(A[i]>max){
                max = A[i];
            }
            r[i] = max;
        }*/
        
        int sum = 0;
        for(int i = 0; i<length; i++){
            sum += Math.min(l[i], r[i]) - A[i];
        }
        return sum;
        
    }
}
