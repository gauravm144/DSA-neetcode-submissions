class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<order.length();i++)
        mp.put(order.charAt(i),i);

        for(int i=0;i<words.length-1;i++){
            String s1=words[i];
            String s2=words[i+1];
            int len=Math.min(s1.length(),s2.length());
            boolean found_point_of_variation=false;
            for(int j=0;j<len;j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    found_point_of_variation=true;
                    if(mp.get(s1.charAt(j))>mp.get(s2.charAt(j)))
                    return false;
                    break;
                }
            }
            if(s1.length()>s2.length()&&found_point_of_variation==false)
            return false;

        }

        return true;
    }
}