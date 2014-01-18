public class Power {
	
	  public double pow(double x, int n) {
        if(n<0) return 1/power(x, -n);
        return power(x, n);
    }
    
    public double power(double x, int n){
        if(n==0) return 1;
        
        double d = power(x, n/2);
        
        if(n%2==0) return d*d;
        else{
            return d*d*x;
        }
    }

}
