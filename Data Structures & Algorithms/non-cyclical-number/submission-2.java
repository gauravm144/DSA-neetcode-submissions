class Solution {
    public boolean isHappy(int n) {
        Set<Integer> s=new HashSet<>();
        while(n!=1){
            int sum=get(n);
            if(sum==1)
            return true;
            
            if(s.contains(sum))
            return false;

            s.add(sum);
            n=sum;
        }
        return true;
    }
    int get(int n){
        int sum=0;
        while(n!=0){
            int val=n%10;
            sum+=val*val;
            n=n/10;
        }
        System.out.println(sum);
        return sum;
    }
}
