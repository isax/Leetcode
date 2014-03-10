public class 3SumClosest  {
    public int threeSumClosest(int[] num, int target) {
        int length = num.length;
        if(length==0) return 0;
        
        Arrays.sort(num);
        int left = 0;
        int right = length-1;
        int minDiff = Integer.MAX_VALUE;
        int res = 0;
        
        for(int i = 0; i<length-2; i++){
            int j = i+1;
            int k = length - 1;
            while(j<k){
                int sum = num[i] + num[j] + num[k];
                int diff = Math.abs(sum-target);
                if(diff<minDiff){
                    minDiff = diff;
                    res = sum;
                }
                if(sum<target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return res;
        
    }
}
