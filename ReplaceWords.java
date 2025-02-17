//TC: O(n*l)+O(m*l), where n is number of words in dictionary, m is no of words in sentence, l is abg length of words
//SC: O(n*l)
//approach: maintaining dictionary as trie/prefix tree

import java.util.HashMap;
import java.util.List;

class TrieNode {
    char c;
    HashMap<Character, TrieNode> map;
    boolean isEnd;

    TrieNode(char c) {
        this.c = c;
        map = new HashMap<>();
        isEnd = false;
    }
}

public class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode('-');
        for (String word : dictionary) {
            insert(root, word);
        }
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String word : words) {
            sb.append(getRoot(root, word));
            sb.append(" ");
        }
        return new String(sb).trim();
    }

    public void insert(TrieNode node, String word) {
        TrieNode temp = node;
        for (int i = 0; i < word.length(); i++) {
            if (!temp.map.containsKey(word.charAt(i))) {
                temp.map.put(word.charAt(i), new TrieNode(word.charAt(i)));
            }
            temp = temp.map.get(word.charAt(i));
        }
        temp.isEnd = true;
    }

    public String getRoot(TrieNode root, String word) {
        TrieNode temp = root;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (temp.map.containsKey(word.charAt(i))) {
                temp = temp.map.get(word.charAt(i));
                sb.append(word.charAt(i));
                if (temp.isEnd) {
                    return new String(sb);
                }
            } else {
                break;
            }
        }
        return word.;
    }
}
