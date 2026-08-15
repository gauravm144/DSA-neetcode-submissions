class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        find(s, new ArrayList<>(), ans);
        return ans;
    }
    void find(String s, List<String> tmp, List<List<String>> ans) {
        if (s.length() == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String str1 = s.substring(0, i + 1);
            String str2 = s.substring(i + 1, s.length());

            if (palin(str1)) {
                tmp.add(str1);

                find(str2, tmp, ans);

                if (!tmp.isEmpty())
                    tmp.remove(tmp.size() - 1);
            }
        }
    }
    boolean palin(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
