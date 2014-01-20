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
}
