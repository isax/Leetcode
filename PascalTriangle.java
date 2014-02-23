public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> generateRecursiveDP(int numRows) {
        ArrayList<ArrayList<Integer>>res = new ArrayList<ArrayList<Integer>>();
        if(numRows==0) return res;
        if(numRows==1){
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(1);
            res.add(list);
            return res;
        }
        
        res = generateRecursiveDP(numRows-1);
        ArrayList<Integer>lastList = res.get(res.size()-1);
        ArrayList<Integer> newList = new ArrayList<Integer>();
        newList.add(1);
        for(int i = 1; i<lastList.size(); i++){
            int a = lastList.get(i-1);
            int b = lastList.get(i);
            newList.add(a+b);
        }
        newList.add(1);
        res.add(newList);
        return res;
    }
    
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>>res = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i<numRows; i++){
            ArrayList<Integer>list = new ArrayList<Integer>();
            list.add(1);
            if(i>0){
                for(int j = 1; j<res.get(i-1).size(); j++){
                    list.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                }
                list.add(1);
            }
            res.add(list);
        }
        return res;
    }
    
}
