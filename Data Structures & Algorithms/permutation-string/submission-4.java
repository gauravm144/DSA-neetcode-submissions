class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
        return false;
        
        int[] count_s1=new int[26];
        for(int i=0;i<s1.length();i++)
        count_s1[s1.charAt(i)-'a']++;

        int[] count_s2=new int[26];
        int start=0,end=0;
        while(end<s1.length())
        count_s2[s2.charAt(end++)-'a']++;

        System.out.println(start+"->"+end);

        if(check(count_s1,count_s2)==true)
        return true;

        while(end<s2.length()){
            count_s2[s2.charAt(start)-'a']--;
            start++;
            count_s2[s2.charAt(end)-'a']++;
            
            if(check(count_s1,count_s2)==true)
                return true;

            end++;
        }
        return false;
    }
    boolean check(int[] c1,int[] c2){
        for(int i=0;i<26;i++)
        if(c1[i]!=c2[i])
        return false;

        return true;
    }
}
