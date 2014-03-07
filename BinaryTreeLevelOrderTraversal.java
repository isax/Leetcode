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
    
    /*
     * DFS
     */
    public ArrayList<ArrayList<Integer>> levelOrderDFS(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if(root==null) return res;
        
        DFShelper(root, 0, res);
        return res;
    }
    
    public void DFShelper(TreeNode root, int level, ArrayList<ArrayList<Integer>> res){
        if(root==null) return;
        
        ArrayList<Integer> levelList;
        if(res.size()==level){
           levelList = new ArrayList<Integer>();
           res.add(levelList);
        }else{
           levelList = res.get(level); 
        }
        levelList.add(root.val);
        DFShelper(root.left, level+1, res);
        DFShelper(root.right, level+1, res);
    }
}
