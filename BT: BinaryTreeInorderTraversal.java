public class BinaryTreeInorderTraversal {
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
    
    /*
     * Iterative
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root==null) return res;
        
        TreeNode cur = root;
        while(!st.isEmpty() || cur !=null ){
            while(cur!=null){
                st.push(cur);
                cur = cur.left;
            }
            
            cur = st.pop();
            res.add(cur.val);
            cur = cur.right;
            
        }
        return res;
    }
}
