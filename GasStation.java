public class GasStation {
    public int canCompleteCircuitBF(int[] gas, int[] cost) {
        int length = gas.length;
        for(int i = 0; i<length; i++){
            int index = 0;
            int gasAmount = gas[i];
            int copyI = i;
            while(index<gas.length){
                gasAmount -= cost[copyI];
                if(gasAmount<0){
                    break;
                }
                else{
                    if(copyI==length-1) copyI = 0;
                    else copyI++;
                    gasAmount += gas[copyI];
                    index++;
                }
            }
            if(gasAmount>=0) return i;
        }
        return -1;
    }
    
    /*
     * A+B+A+B: sum in A < 0, B+A>0, B>0, leftGas=B+A+B>=0
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int leftGas = 0;
        int start = 0;
        for(int i = 0; i<2*length; i++){
            leftGas += gas[i%length] - cost[i%length];
            if(leftGas<0){
                leftGas = 0;
                start = i+1;
            }
        }
        if(start>length) return -1;
        else return start; //leftGas>=0
    }
}
