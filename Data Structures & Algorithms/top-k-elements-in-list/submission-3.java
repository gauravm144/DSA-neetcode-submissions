class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
    
        List<Integer>[] bucket=new ArrayList[nums.length+1];
        for(Map.Entry<Integer,Integer> entry:mp.entrySet()){
            int key=entry.getKey();
            int val=entry.getValue();
            if(bucket[val]==null)
            bucket[val]=new ArrayList<>();

            bucket[val].add(key);
        }
        int[] ans=new int[k];
        int idx=0;
        for(int i=nums.length;i>=0&&idx<k;i--){
            if(bucket[i]!=null){
                for(int j=0;j<bucket[i].size();j++){
                    ans[idx++]=bucket[i].get(j);
                    if(idx==k)
                    break;
                }
            }
        }
        return ans;
    }
}
