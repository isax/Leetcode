public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer>res = new ArrayList<Integer>();
        res.add(0);
        
        for(int i = 0; i<n; i++){
            int k = 1<<i;
            int length = res.size();
            for(int j = length-1; j>=0; j--){
                res.add(res.get(j)+k);
            }
        }
        return res;
    }
}
