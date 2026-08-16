class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < numCourses; i++) mp.put(i, new ArrayList<>());

        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            if(from==to)
            return false;
            mp.get(from).add(to);
            indegree[to]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }
        if (q.isEmpty())
            return false;
        int processedcourses=0;
        while (!q.isEmpty()) {
            int idx = q.poll();
            processedcourses++;
            System.out.println(idx);
            List<Integer> neighbours = mp.get(idx);
            for (int i = 0; i < neighbours.size(); i++) {
                indegree[neighbours.get(i)]--;
                if(indegree[neighbours.get(i)]==0)
                q.offer(neighbours.get(i));
            }
        }
        return processedcourses==numCourses;
    }
}
