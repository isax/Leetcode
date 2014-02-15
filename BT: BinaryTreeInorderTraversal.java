public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(root, list);
        
        return list;
    }
    
    public void helper(TreeNode root, ArrayList<Integer>list){
        if(root==null) return;
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
        
    }
}
