public class ReverseWordsinaString {
    public String reverseWords2(String s) {
        String[]array = s.split(" ");
        Stack<String>st = new Stack<String>();
        for(String str: array){
            if(!str.equals(""))st.add(str);
        }
        StringBuffer sb = new StringBuffer();
        while(!st.isEmpty()){
            sb.append(st.pop());
            if(!st.isEmpty()) sb.append(" ");
        }
        return sb.toString();
    }
    
    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        Stack<String>st = new Stack<String>();
        int start = -1;
        s = s +' '; // for last nonempty string
        
        for(int i = 0; i<s.length(); i++){
            if(start==-1 && s.charAt(i)!=' ') start = i;
            else if(start!=-1 && s.charAt(i)==' ') {
                st.add(s.substring(start, i));
                start = -1;
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
            if(!st.isEmpty()) sb.append(" ");
        }
        return sb.toString();
    }
}
