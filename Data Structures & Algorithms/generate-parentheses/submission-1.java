class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        find(0,0,n,new StringBuilder(),ans);
        return ans;
        
    }
    void find(int open,int closed,int n,StringBuilder str,List<String> ans){
        if(str.length()==n*2){
            String tmp=new String(str.toString());
            ans.add(tmp);
            return;
        }
        if(open<n){
        str.append('(');
        find(open+1,closed,n,str,ans);
        str.deleteCharAt(str.length() - 1);
        }
        if(closed<open){
        str.append(')');
        find(open,closed+1,n,str,ans);
        str.deleteCharAt(str.length() - 1);
        }
    }
}
