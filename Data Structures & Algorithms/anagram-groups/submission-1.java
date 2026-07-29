class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp=new HashMap<>();
        
        for(String s:strs){

            int[] freq=new int[26];
            
            for(int i=0;i<s.length();i++)
            freq[s.charAt(i)-'a']++;

            String tmp=Arrays.toString(freq);

            mp.putIfAbsent(tmp,new ArrayList<>());
            mp.get(tmp).add(s);
        }
        return new ArrayList<>(mp.values());
    }
}
