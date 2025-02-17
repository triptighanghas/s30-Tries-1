//TC:O(nl), where n=no of words, l=avg length of each word
//SC:O(nl)
//approach: prefix tree/trie

/*passing sample tests, failing for this test case on submission:
        words =
        ["yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"]
        output: "ewqz"
        expected: "yodn"*/

public class LongestWordInDictionary {
    Node root;
    int maxLength;
    String result;
    public String longestWord(String[] words) {
        root = new Node();
        maxLength = 0;
        result = "";
        for(String word:words){
            insert(word);
        }
        for(int i=0;i<26;i++){
            recurse(root.children[i], 0, 0, new StringBuilder(), i);
        }

        return result;
    }

    void insert(String word){
        Node curr = root;
        for(int i = 0; i<word.length();i++){
            char c = word.charAt(i);
            if(null == curr.children[c-'a'])
                curr.children[c-'a'] = new Node();
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    void recurse(Node node, int length, int isEndCount, StringBuilder curr, int index){
        if(null == node) return;

        length++;
        if(node.isEnd) isEndCount++;
        char c = (char) ('a' + index);
        curr.append(c);
        if(length>maxLength && isEndCount>1){
            maxLength = length;
            result = curr.toString();
        }
        for(int i=0;i<26;i++){
            recurse(node.children[i], length, isEndCount, curr, i);
        }
    }
}

class Node{
    boolean isEnd;
    Node[] children;
    public Node(){
        children = new Node[26];
    }
}
