public class LetterCombinationsPhoneNumber  {
    public ArrayList<String> letterCombinations(String digits) {
        String [] digit= {" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[]charArray = new char[digits.length()];
        ArrayList<String> res = new ArrayList<String>();
        helper(digits, 0, charArray, res, digit);
        return res;
    }
    
    public void helper(String digits, int index, char[] charArray, ArrayList<String>res, String[]digit){
        if(index==digits.length()) {
            String str = String.valueOf(charArray);
            res.add(str);
            return;
        }
        char cur = digits.charAt(index);
        char[] letters = digit[cur-'0'].toCharArray();
        for(char l: letters){
            charArray[index] = l;
            helper(digits, index+1, charArray, res, digit);
        }
    }
}
