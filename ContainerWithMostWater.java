public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = height.length-1;
        
        while(i<j){
            int cur = Math.min(height[i], height[j]) *Math.abs(i-j);
            if(cur>max) max = cur;
            
            if(height[i]<=height[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
}
