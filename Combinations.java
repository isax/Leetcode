public class Combinations {
    /*
     * DFS + Backtracking
     */
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(n<1 || k<1 || n<k){
            return res;
        }
        helper(n, k, 0, list, res);
        return res;
    }
    
    public void helper(int n, int k, int cur, ArrayList<Integer>list, ArrayList<ArrayList<Integer>> lists){
        if(k==list.size()){
            lists.add((ArrayList)list.clone());
            return;
        }
        
        for(int i = cur+1; i<=n; i++){
            list.add(i);
            helper(n, k, i, list, lists);
            list.remove(list.size()-1);
        }
    }
}
