public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root==null) return res;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode head = root;// cannot be initialized to null, 
                    //because first iteration needs to check if(cur.right==head) e.g.{1, 2} will return only{1}
        while(!stack.isEmpty()){
            TreeNode cur = stack.peek();
            if((cur.left==null&&cur.right==null)|| cur.right == head|| (cur.right==null&&cur.left==head)){
                head = cur;
                res.add(stack.pop().val);
            }else{
                if(cur.right!=null) stack.push(cur.right);
                if(cur.left!=null) stack.push(cur.left);
            }
        }
        return res;
    }
}
