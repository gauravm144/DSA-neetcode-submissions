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
        System.out.println(str);
        List<String> ans=new ArrayList<>();
        for(int i=0;i<str.length();i++){
            int idx=str.indexOf("#",i);
            if(idx==-1)
            break;
            System.out.println(idx);
            String num=str.substring(i,idx);
            int vl=Integer.parseInt(num);
            String txt=str.substring(idx+1,idx+1+vl);
            ans.add(txt);
            if(idx!=-1)
            i=idx+vl;
        }
        return ans;
    }
}
