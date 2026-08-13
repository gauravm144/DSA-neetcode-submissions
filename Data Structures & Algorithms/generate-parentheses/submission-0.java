class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        find(0,n*2,new StringBuilder(),ans);
        return ans;
        
    }
    void find(int i,int n,StringBuilder str,List<String> ans){
        if(i==n){
            String tmp=new String(str.toString());
            if(valid(tmp))
            ans.add(tmp);
            return;
        }
        str.append('(');
        find(i+1,n,str,ans);
        str.deleteCharAt(str.length() - 1);
        str.append(')');
        find(i+1,n,str,ans);
        str.deleteCharAt(str.length() - 1);
    }
    boolean valid(String s){
        Stack<Character> stk=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
            stk.push('(');
            else{
                if(stk.isEmpty()||stk.peek()==')')
                return false;
                stk.pop();

            }
        }
        return stk.isEmpty();

    }
}
