class Solution {

    public String encode(List<String> strs) {
        StringBuilder str=new StringBuilder();
        for(String s:strs){
            str.append(s.length());
            str.append("#");
            str.append(s);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> ans=new ArrayList<>();
        for(int i=0;i<str.length();i++){
            int idx=str.indexOf("#",i);

            String num=str.substring(i,idx);
            int vl=Integer.parseInt(num);
            ans.add(str.substring(idx+1,idx+1+vl));
            i=idx+vl;
        }
        return ans;
    }
}
