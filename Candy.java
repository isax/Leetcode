public class Candy {
    public int candy(int[] ratings) {
        int length = ratings.length;
        int [] res = new int[length];
        int [] res2 = new int[length];
        
        for(int i = 0; i<length; i++){
            res[i] = 1;
            res2[i] = 1;
        }
        
        for(int i = 1; i<length; i++){
            if(ratings[i]>ratings[i-1]) res[i] = res[i-1]+1;
        }
        
        for(int i = length-2; i>=0; i--){
            if(ratings[i]>ratings[i+1]) res2[i] = res2[i+1]+1; 
        }
        
        int sum = 0;
        for(int i = 0; i<length; i++){
            sum += Math.max(res[i], res2[i]);
        }
        return sum;
    }
}
