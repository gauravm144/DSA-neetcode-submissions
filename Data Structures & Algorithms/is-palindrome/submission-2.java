class Solution {
    public boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while(i<j){
            char ch1=s.charAt(i);
            if(ch1>='0'&&ch1<='9'||ch1>='a'&&ch1<='z'||ch1>='A'&&ch1<='Z')
            {
                if(ch1>='A'&&ch1<='Z')
                ch1= Character.toLowerCase(ch1);
            }
            else{
                i++;
               continue;
            }
            char ch2=s.charAt(j);
            if(ch2>='0'&&ch2<='9'||ch2>='a'&&ch2<='z'||ch2>='A'&&ch2<='Z')
            {
                if(ch2>='A'&&ch2<='Z')
                ch2= Character.toLowerCase(ch2);
            }
            else{
                j--;
               continue;
            }
            if(ch1!=ch2)
            return false;
            i++;
            j--;
        }
        return true;
    }
}
