public class RomantoInteger {
    /*
     * Biggest one 3999: MMM CM XC IX
     */
    public int romanToInt(String s) {
        char prev = ' ';
        int sum = 0;
        
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='M' && prev!='C') sum += 1000;
            if(c=='C' && prev!='X') sum += 100;
            if(c=='X' && prev!='I') sum += 10;
            
            if(c=='M' && prev=='C') sum += 800;
            if(c=='C' && prev=='X') sum += 80;
            if(c=='X' && prev=='I') sum += 8;
            
            if(c=='I') sum += 1;
            
            if(c=='V' && prev!='I') sum += 5;
            if(c=='L' && prev!='X') sum += 50;
            if(c=='D' && prev!='C') sum += 500;
            
            if(c=='V' && prev=='I') sum += 3;
            if(c=='L' && prev=='X') sum += 30;
            if(c=='D' && prev=='C') sum += 300;
            
            prev = c;
        }
        return sum;
        
    }
}
