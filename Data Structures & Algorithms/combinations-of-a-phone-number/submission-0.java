class Solution {
    public List<String> letterCombinations(String digits) {
        String[] keys={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans=new ArrayList<>();
        find(0,keys,new StringBuilder(),ans,digits);
        return ans;
    }
    void find(int i,String[] keys,StringBuilder cur,List<String> ans,String digits){
        if(i==digits.length()){
            if(cur.length()!=0)
            ans.add(cur.toString());
            return;
        }
        String letters=keys[digits.charAt(i)-'2'];
        for(char ch:letters.toCharArray()){
            cur.append(ch);
            find(i+1,keys,cur,ans,digits);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
