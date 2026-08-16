class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < numCourses; i++) mp.put(i, new ArrayList<>());

        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            if(from==to)
            return new int[0];
            mp.get(from).add(to);
            indegree[to]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        int[] ans=new int[numCourses];
        int k=numCourses-1;
        while (!q.isEmpty()) {
            int idx = q.poll();
            ans[k--]=idx;
            List<Integer> neighbours = mp.get(idx);
            for (int i = 0; i < neighbours.size(); i++) {
                indegree[neighbours.get(i)]--;
                if(indegree[neighbours.get(i)]==0)
                q.offer(neighbours.get(i));
            }
        }

        for(int i=0;i<numCourses;i++)
        if(indegree[i]!=0)
        return new int[0];

        return ans;

    }
}
