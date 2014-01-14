public class Parenthese {
	
	/*
	 * DFS
	 */
	public static void addParen(ArrayList<String>res, int left, int right, char[]str, int count){
		if(left<0||left>right) return; //invalid
		
		if(left==0&&right==0){ // no more parens left
			String s = String.copyValueOf(str); // convert char array to string
			res.add(s);
			return;
		}
		
		if(left>0){ // add left, if there are left parens left
			str[count] = '(';
			addParen(res, left-1, right, str, count+1);
		}
		
		if(right>left){ // add right, if valid
			str[count] = ')';
			addParen(res, left, right-1, str, count+1);
		}
		
	}
	
	public static ArrayList<String> generateParenthesis(int n){
		ArrayList<String> res = new ArrayList<String>();
		char[]str = new char[n*2];
		addParen(res, n, n, str, 0);
		return res;
	}
	
	
	/*
	 * inefficient
	 * 
	 */
	public static ArrayList<String> parentheses(int n){
		if(n<0) return null;
		
		ArrayList<String> res = new ArrayList<String>();
		if(n==0) { //base case
			String str = "";
			res.add(str);
			return res;	
		}
		
		ArrayList<String> prevRes = parentheses(n-1);
		for(String s : prevRes){
			for(int i=0; i<s.length(); i++){
				if(s.charAt(i)=='('){
					String newStr = insertIntoStr(s, i);
					if(!res.contains(newStr)) res.add(newStr);
				}
			}
			String beginning = "()" + s;
			if(!res.contains(beginning)) res.add(beginning);
		}
		
		return res;
		
	}

}
