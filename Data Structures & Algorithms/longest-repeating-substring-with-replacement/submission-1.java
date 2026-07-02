class Solution {
    public int characterReplacement(String s, int k) {
        int left=0,right=0;
        int ans=0;
        int maxfreqinwindow=0;
        int[] freq=new int[26];
        while(right<s.length()){
            char ch=s.charAt(right);
            freq[ch-'A']++;
            maxfreqinwindow=Math.max(maxfreqinwindow,freq[ch-'A']);
            while((right-left+1)-maxfreqinwindow>k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            ans=Math.max(ans,(right-left+1));
            right++;
        }
        return ans;
    }
}
// Window ke andar jis character ki frequency sabse zyada hai, 
// usko change mat karo. Baaki sabko usme convert kar do.