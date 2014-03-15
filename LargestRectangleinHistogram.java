public class LargestRectangleinHistogram  {
    public int largestRectangleArea(int[] height) {
        int length = height.length;
        int maxArea = 0;
        
        for(int i = 0; i<length; i++){
            
            if(i!=length-1 && height[i]<=height[i+1]) continue;
            
            int minHeight = height[i];
            for(int j = i; j>=0; j--){
                minHeight = Math.min(minHeight, height[j]);
                
                int area = minHeight*(i-j+1);
                maxArea = Math.max(area, maxArea);
                
            }
        }
        return maxArea;
    }
    
    /*
     * Stack O(n)
     */
    public int largestRectangleArea2(int[] height) {
        int length = height.length;
        int maxArea = 0;
        int []L = new int[length];
        int []R = new int[length];
        
        Stack<Integer>stack = new Stack<Integer>(); // store index
        
        for(int i = 0; i<length; i++){
            while(!stack.isEmpty() && height[stack.peek()] >= height[i]){
                stack.pop();
            }
            L[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i = length-1; i>=0; i--){
            while(!stack.isEmpty() && height[stack.peek()] >= height[i]){
                stack.pop();
            }
            R[i] = stack.isEmpty()?length:stack.peek();
            stack.push(i);
        }
        
        for(int k = 0; k<length; k++){
            maxArea = Math.max(maxArea, height[k]*(R[k]-L[k]-1));
        }
        return maxArea;
    }
}
