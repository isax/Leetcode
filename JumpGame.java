public class JumpGame {
    /*
     * Reference links: http://jane4532.blogspot.com/2013/06/jump-game-i-leetcode.html
     *                  http://fisherlei.blogspot.com/2012/12/leetcode-jump-game.html
     *                  http://oj.leetcode.com/discuss/3104/this-is-my-answer
     *
     */
    public boolean canJump2(int[] A) {
        int length = A.length;
        int []jump = new int[length];
        
        jump[0] = 0;
        for(int i = 1; i<length; i++){
            jump[i] = Math.max(jump[i-1], A[i-1]) - 1;
            if(jump[i]<0) return false;
        }
        return true;
    }
    
    public boolean canJump3(int[] A) {
        int length = A.length;
        boolean res = true;
        int j = length-1;

        for(int i = length-2; i>=0; i--){
            if(A[i]==0){
                res = false;
            }else if(A[i]>0 && !res){
                if(A[i]>=j-i){
                   res = true;
                   j = i;
                }
            }else{
                j = i;
            }
        }
        return res;
    }
    
    public boolean canJump(int[] A) {
        int length = A.length;
        int canReach = 0;
        for(int i = 0; i<length&& i<=canReach; i++){
           if(A[i]+i>canReach) canReach = A[i] + i;
           if(canReach>=length-1) return true;
        }
        return (canReach>=length-1);
    }
}
