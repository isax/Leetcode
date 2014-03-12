public class SingleNumberII {
    public int singleNumber(int[] A) {
        int single_number = 0;
        for (int i = 0; i < 32; i++) {// int 32
            int bit = 0;
            for (int j = 0; j < A.length; j++) {
                bit = (bit + ((A[j] >> i) & 1)) % 3;
            }
            single_number += (bit << i);
        }
        return single_number;
        
    }

}
