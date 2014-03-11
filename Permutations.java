public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res;
        if(num.length==0) {
            res = new ArrayList<ArrayList<Integer>>();
            return res;
        }
        res = helper(num, num.length-1);
        return res;
    }
    
    public ArrayList<ArrayList<Integer>> helper(int[]num, int index){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>> ();
        if(index==0){
            ArrayList<Integer> single = new ArrayList<Integer>();
            single.add(num[index]);
            res.add(single);
            return res;
        }
        ArrayList<ArrayList<Integer>> list = helper(num, index-1);
        for(ArrayList<Integer> l: list){
            for(int i= 0; i<=index; i++){
                ArrayList<Integer> newList = (ArrayList)l.clone();
                newList.add(i, num[index]);
                res.add(newList);
            }
        }
        return res;
    }
    
    
    /*
     * dfs swap
     */
     public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        helper(num, 0, res);
        return res;
    }
    
    public void helper(int[]num, int start, ArrayList<ArrayList<Integer>> res){
        if(start==num.length){
            ArrayList<Integer> list = convert(num);
            res.add(list);
        }
        
        for(int i = start; i<num.length;i++){
                swap(num, start, i);
                helper(num, start+1, res);
                swap(num, start, i);
        }
    }
    
    public ArrayList<Integer> convert(int[]num){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i:num){
            list.add(i);
        }
        return list;
    } 
    
    public void swap(int []num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
