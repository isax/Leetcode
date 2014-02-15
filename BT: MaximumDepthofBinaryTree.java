public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        return (int)Math.max(leftDepth, rightDepth) + 1;
    }
}
