public class PermutationsII {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
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
            if(noDuplicates(num, start, i)){
                swap(num, start, i);
                helper(num, start+1, res);
                swap(num, start, i);
            }
        }
    }
    
    public ArrayList<Integer> convert(int[]num){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i:num){
            list.add(i);
        }
        return list;
    } 
    public boolean noDuplicates(int[]num, int start, int end){
        for(int i = start; i<end; i++){
            if(num[i]==num[end]) return false;
        }
        return true;
    }
    
    public void swap(int []num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
        
}
