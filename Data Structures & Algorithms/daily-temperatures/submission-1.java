class Solution {
    public int[] dailyTemperatures(int[] tmp) {
        int[] ans=new int[tmp.length];
        Stack<Integer> stk=new Stack<>();
        for(int i=tmp.length-1;i>=0;i--){
            while(!stk.isEmpty()&&tmp[stk.peek()]<=tmp[i])
            stk.pop();
            if(stk.isEmpty())
            ans[i]=0;
            else
            ans[i]=stk.peek()-i;
            
            stk.push(i);


        }
        return ans;
    }
}
