public class UniqueBinarySearchTreesII {
    public ArrayList<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    
    /*
     * DFS 
     */
    public ArrayList<TreeNode> helper(int start, int end){
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        
        if(start>end) res.add(null); //only 2 cases: left subtree==null or right subtree==null
        else if(start==end) res.add(new TreeNode(start));
        else{
            for(int i = start; i<=end; i++){
                ArrayList<TreeNode> leftsub = helper(start, i-1);
                ArrayList<TreeNode> rightsub = helper(i+1, end);
                
                for(TreeNode left : leftsub){
                    for(TreeNode right : rightsub){
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        res.add(root);
                    }
                }
            }
        }
        return res;
    }
}
