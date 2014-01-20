public class BinaryTreePreorderTraversal {
    
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        preorderHelper(root, res);
        return res;
    }
    
    public void preorderHelper(TreeNode root, ArrayList<Integer> list){
        if(root==null) return;
        list.add(root.val);
        preorderHelper(root.left, list);
        preorderHelper(root.right, list);
    }
    
    /*
     * Iterative approach: use a stack.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root==null) return res;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.right!=null) stack.push(cur.right);
            if(cur.left!=null) stack.push(cur.left);
        }
        
        return res;
    }
}
