class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='}'||ch==']'||ch==')'){
                if(stk.isEmpty())
                    return false;
                if(ch=='}'&&stk.peek()!='{')
                    return false;
                if(ch==']'&&stk.peek()!='[')
                    return false;
                if(ch==')'&&stk.peek()!='(')
                    return false;
                stk.pop();
            }
            else
            stk.push(ch);
        }
        return stk.isEmpty();
    }
}
