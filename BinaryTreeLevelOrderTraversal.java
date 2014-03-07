public class BinaryTreeLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if(root==null) return res;
        
        Queue <TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        queue.add(root);
        
        int curLevel = 1;
        int nextLevel = 0;
        
        while(!queue.isEmpty()){
            TreeNode cur  = queue.remove();
            level.add(cur.val);
            curLevel--;
            
            if(cur.left!=null) {
                queue.add(cur.left);
                nextLevel++;
            }
            if(cur.right!=null) {
                queue.add(cur.right);
                nextLevel++;
            }
            if(curLevel==0){
                res.add(level);
                level = new ArrayList<Integer>();
                curLevel = nextLevel;
                nextLevel = 0;
            }
        }
        return res;
    }
}
