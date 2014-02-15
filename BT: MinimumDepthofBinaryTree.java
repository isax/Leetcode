public class MinimumDepthofBinaryTree {
    
    /*
     * DFS
     */
    public int minDepthDFS(TreeNode root) {
        if(root==null) return 0;
        
        if(root.left==null && root.right==null) return 1;
        else if(root.left==null) return minDepthDFS(root.right)+1;
        else if(root.right==null) return minDepthDFS(root.left)+1;
        else return Math.min(minDepthDFS(root.left), minDepthDFS(root.right))+1;
        
    }
    
    /*
     * BFS
     */
    public int minDepthBFS(TreeNode root) {
        if(root==null) return 0;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        int depth = 1;
        while(!q.isEmpty()){
            Queue<TreeNode> cur = new LinkedList<TreeNode>();
            for(TreeNode node: q){
                if(node.left==null && node.right==null) return depth;
                if(node.left!=null) cur.add(node.left);
                if(node.right!=null) cur.add(node.right);
            }
            q = cur;
            depth++;
        }
        
        return depth;
    }
    
    public int minDepthBFS2(TreeNode root) {
        if(root==null) return 0;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        HashMap<TreeNode, Integer> hm = new HashMap<TreeNode, Integer>();
        q.add(root);
        hm.put(root, 1);
        
        while(!q.isEmpty()){
            TreeNode cur = q.remove();
            int depth = hm.get(cur);
            if(cur.left==null && cur.right==null){
                return depth;
            }
            
            if(cur.left!=null){
                q.add(cur.left);
                hm.put(cur.left, depth+1);
            }
            
            if(cur.right!=null){
                q.add(cur.right);
                hm.put(cur.right, depth+1);
            }
        }
        return 0;
    }
    
}
