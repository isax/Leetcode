public class PathSumII {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(root, sum, list, lists);
        
        return lists;
    }
    
    public void helper(TreeNode root, int sum, ArrayList<Integer>list, ArrayList<ArrayList<Integer>> lists){
        if(root==null) return;
        
        list.add(root.val);
        if(root.left==null&&root.right==null&&root.val==sum){
            ArrayList<Integer>newList = new ArrayList<Integer>();
            newList.addAll(list);
            lists.add(newList);
        }
        helper(root.left, sum-root.val, list, lists);
        helper(root.right, sum-root.val, list, lists);
        list.remove(list.size()-1); // recursively pop the current node...!
    }
}
