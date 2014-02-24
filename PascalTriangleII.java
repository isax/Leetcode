public class PascalTriangleII {
    public ArrayList<Integer> getRow(int rowIndex) {
        int [] row = new int[rowIndex+1];
        row[0] = 1;
        if(rowIndex==0) return getList(row);
        for(int i = 1; i<=rowIndex; i++){
            for(int j = i-1; j>0; j--){
                row[j] = row[j]+row[j-1];
            }
            row[i] = 1;
        }
        return getList(row);
    }
    
    public ArrayList<Integer> getList(int [] row){
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int r: row){
            res.add(r);
        }
        return res;
    }
}
