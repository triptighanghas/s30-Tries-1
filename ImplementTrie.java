//TC: O(l), where l is length of word/prefix
//SC: O(n*m), where n is number of words inserted, m is avg length of each word
//approach: Trie

public class ImplementTrie {

    class Node {
        boolean isEnd;
        Node[] children;

        public Node() {
            children = new Node[26];
        }
    }

    class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (null == curr.children[c - 'a']) {
                    curr.children[c - 'a'] = new Node();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
        }

        public boolean search(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (null == curr.children[c - 'a']) return false;
                curr = curr.children[c - 'a'];
            }
            return curr.isEnd;
        }

        public boolean startsWith(String prefix) {
            Node curr = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (null == curr.children[c - 'a']) return false;
                curr = curr.children[c - 'a'];
            }
            return true;
        }
    }
}
