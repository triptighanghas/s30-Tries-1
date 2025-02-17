//TC: O(nlogn + nl), for sorting words, and creating/traversing prefix tree
//SC: O(nl)
//approach: prefix tree

import java.util.Arrays;

public class LongestWordInDictionaryFixed {
    Node root;
    int maxLength;
    String result;

    public String longestWord(String[] words) {
        root = new Node();
        maxLength = 0;
        result = "";

        Arrays.sort(words);

        for (String word : words) {
            insert(word);
        }

        recurse(root, new StringBuilder());
        return result;
    }

    void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    void recurse(Node node, StringBuilder curr) {
        if (node == null) return;

        if (curr.length() > maxLength) {
            maxLength = curr.length();
            result = curr.toString();
        }

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null && node.children[i].isEnd) {
                char c = (char) ('a' + i);
                curr.append(c);
                recurse(node.children[i], curr);
                curr.deleteCharAt(curr.length() - 1); // Backtrack
            }
        }
    }
}

