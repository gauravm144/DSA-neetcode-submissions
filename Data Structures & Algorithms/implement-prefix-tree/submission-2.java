class Trie {
    Trie[] trie = new Trie[26];
    boolean end = false;
}
class PrefixTree {
    Trie root;
    public PrefixTree() {
        root = new Trie();
    }

    public void insert(String word) {
        Trie tmp = root;
        int idx = 0;
        while (idx < word.length()) {
            int pos = word.charAt(idx) - 'a';
            if (tmp.trie[pos] == null) {
                tmp.trie[pos] = new Trie();
            }
            tmp = tmp.trie[pos];
            idx++;
        }
        tmp.end = true;
    }

    public boolean search(String word) {
        Trie tmp = root;
        int idx = 0;
        while (tmp != null && idx < word.length()) {
            int pos = word.charAt(idx) - 'a';
            if (tmp.trie[pos] == null) {
                return false;
            } else
                tmp = tmp.trie[pos];
            idx++;
        }
        return tmp.end;
    }

    public boolean startsWith(String prefix) {
        Trie tmp = root;
        int idx = 0;
        while (tmp != null && idx < prefix.length()) {
            int pos = prefix.charAt(idx) - 'a';
            if (tmp.trie[pos] == null) {
                return false;
            } else
                tmp = tmp.trie[pos];
            idx++;
        }
        return true;
    }
}
