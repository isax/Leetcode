public class Triangle {
    
    /*
     * Bottom-up DP is better, Top-down will overwrite the data we need.
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int n = triangle.size();
        int [] temp = new int[n];
        
        for(int i = 0; i<n; i++){
            temp[i] = triangle.get(n-1).get(i);
        }
        
        // dp: iterate from row n-2
        for(int j = n-2; j>=0; j--){
            ArrayList<Integer> level = triangle.get(j);
            for(int i = 0; i<=j; i++){
                temp[i] = level.get(i) + Math.min(temp[i], temp[i+1]);
            }
        }
        return temp[0];
    }
}
