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
}
