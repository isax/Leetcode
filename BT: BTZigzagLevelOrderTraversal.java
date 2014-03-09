public class BTZigzagLevelOrderTraversal  {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root==null) return res;
        
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        
        int count = 1;
        int nextLevel = 0;
        boolean flag = true;
        
        ArrayList<Integer> level = new ArrayList<Integer>();
        
        while(!list.isEmpty()){
            TreeNode cur = list.remove(0);
            
            if(flag) level.add(cur.val);
            else level.add(0, cur.val);
            
            count--;
            
            if(cur.left!=null){
                list.add(cur.left);
                nextLevel++;
            }
            if(cur.right!=null){
                list.add(cur.right);
                nextLevel++;
            }
            
            if(count==0){
                res.add(level);
                level = new ArrayList<Integer>();
                count = nextLevel;
                nextLevel = 0;
                flag = flag?false: true;
            }
        }
        return res;
    }
}
