class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();

        // 1. Initially every account is its own group
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 2. email -> account index
        Map<String, Integer> emailToAccount = new HashMap<>();

        // 3. Union accounts having common email
        for (int i = 0; i < n; i++) {

            // Start from 1 because index 0 is the name
            for (int j = 1; j < accounts.get(i).size(); j++) {

                String email = accounts.get(i).get(j);

                if (emailToAccount.containsKey(email)) {

                    int oldAccount = emailToAccount.get(email);

                    int rootA = find(oldAccount, parent);
                    int rootB = find(i, parent);

                    if (rootA != rootB) {
                        parent[rootB] = rootA;
                    }

                } else {
                    emailToAccount.put(email, i);
                }
            }
        }

        // 4. root -> all emails belonging to that group
        Map<Integer, List<String>> groups = new HashMap<>();

        for (Map.Entry<String, Integer> entry : emailToAccount.entrySet()) {

            String email = entry.getKey();
            int accountIndex = entry.getValue();

            int root = find(accountIndex, parent);

            if (!groups.containsKey(root)) {
                groups.put(root, new ArrayList<>());
            }

            groups.get(root).add(email);
        }

        // 5. Build final answer
        List<List<String>> ans = new ArrayList<>();

        for (Map.Entry<Integer, List<String>> entry : groups.entrySet()) {

            int root = entry.getKey();
            List<String> emails = entry.getValue();

            Collections.sort(emails);

            List<String> account = new ArrayList<>();

            // Name of the root account
            account.add(accounts.get(root).get(0));

            // Add sorted emails
            for (String email : emails) {
                account.add(email);
            }

            ans.add(account);
        }

        return ans;
    }

    int find(int x, int[] parent) {

        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x], parent);
    }
}