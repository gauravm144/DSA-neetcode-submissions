class Node {
    int i;
    int j;
    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<Node> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0)
                    q.offer(new Node(i, j));
            }
        }
        int num = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int start = 1; start <= size; start++) {
                Node node = q.poll();
                int i = node.i;
                int j = node.j;

                // left
                if (j > 0 && grid[i][j - 1] == Integer.MAX_VALUE) {
                    q.offer(new Node(i, j - 1));
                    grid[i][j - 1] = num;
                }
                // up
                if (i > 0 && grid[i - 1][j] == Integer.MAX_VALUE) {
                    q.offer(new Node(i - 1, j));
                    grid[i - 1][j] = num;
                }
                // right
                if (j < m - 1 && grid[i][j + 1] == Integer.MAX_VALUE) {
                    q.offer(new Node(i, j + 1));
                    grid[i][j + 1] = num;
                }
                // down
                if (i < n - 1 && grid[i + 1][j] == Integer.MAX_VALUE) {
                    q.offer(new Node(i + 1, j));
                    grid[i + 1][j] = num;
                }
            }
            num++;
        }
    }
}
