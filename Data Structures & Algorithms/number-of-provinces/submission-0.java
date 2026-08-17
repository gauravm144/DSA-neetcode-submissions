class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int prov = n;
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) parent[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    int a = findParent(i, parent);
                    int b = findParent(j, parent);
                    if (a != b) {
                        parent[b] = a;
                        prov--;
                    }
                }
            }
        }
        return prov;
    }
    int findParent(int x, int[] parent) {
        if (parent[x] == x)
            return x;

        return findParent(parent[x], parent);
    }
}

// Initially:
// n nodes = n groups

// For every connection:
//     connected?
//         ↓
//     find(rootA)
//     find(rootB)
//         ↓
//     same root?
//       /     \
//     yes      no
//     ↓         ↓
//  ignore     union
//               ↓
//           groups--