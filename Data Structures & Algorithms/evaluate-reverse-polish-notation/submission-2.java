class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk=new Stack<>();
        for(String s:tokens){
            if(s.length()==1&&(s.charAt(0)=='+'||s.charAt(0)=='-'||s.charAt(0)=='*'||s.charAt(0)=='/')){
                int top=stk.pop();
                int secondtop=stk.pop();
                char ch=s.charAt(0);
                int tmp=0;
                switch(ch){
                    case '+':tmp=secondtop+top;
                    break;
                    case '-':tmp=secondtop-top;
                    break;
                    case '*':tmp=secondtop*top;
                    break;
                    case '/':tmp=secondtop/top;
                    break;
                }
                System.out.println(tmp);
                stk.push(tmp);
            }
            else
            stk.push(Integer.parseInt(s));
        }
        return stk.peek();
    }
}
