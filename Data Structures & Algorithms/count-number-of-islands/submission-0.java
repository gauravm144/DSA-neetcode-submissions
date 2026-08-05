class Node {
    int i;
    int j;
    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        Queue<Node> q = new LinkedList<>();
        int ans = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    q.offer(new Node(row, col));
                    grid[row][col] = '0';
                    ans++;
                    while (!q.isEmpty()) {
                        Node node = q.poll();
                        int i = node.i;
                        int j = node.j;
                        // left
                        if (j > 0 && grid[i][j - 1] == '1') {
                            q.offer(new Node(i, j - 1));
                            grid[i][j - 1] = '0';
                        }
                        // up
                        if (i > 0 && grid[i - 1][j] == '1') {
                            q.offer(new Node(i - 1, j));
                            grid[i - 1][j] = '0';
                        }
                        // right
                        if (j < grid[0].length - 1 && grid[i][j + 1] == '1') {
                            q.offer(new Node(i, j + 1));
                            grid[i][j + 1] = '0';
                        }
                        // down
                        if (i < grid.length - 1 && grid[i + 1][j] == '1') {
                            q.offer(new Node(i + 1, j));
                            grid[i + 1][j] = '0';
                        }
                    }
                }
            }
        }
        return ans;
    }
}
