import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
  static class Node {
    HashMap<Character, Node> Children = new HashMap<>();
    boolean isWord = false;
    String Word = "";
  }
  static class Trie {
    Node root;
    Trie() {
      root = new Node();
    }
    public void addWord(String word) {
      Node cur = root;
      int size = word.length();
      for (int pos = 0; pos < size; pos++) {
        char ch = word.charAt(pos);
        if (!cur.Children.containsKey(ch)) {
          cur.Children.put(ch, new Node());
        }
        cur = cur.Children.get(ch);
      }
      cur.isWord = true;
      cur.Word = word;
    }
  }
  int ROW, COL;
  public List<String> findWords(char[][] board, String[] words) {
     ROW = board.length;
     COL = board[0].length;
     boolean[][] visit = new boolean[ROW][COL];
     HashSet<String> hashSet = new HashSet<>();
     Trie trie = new Trie();
    for (String word : words) {
      trie.addWord(word);
    }
     for (int row = 0; row < ROW; row++) {
       for (int col = 0; col < COL; col++) {
         DFS(row, col, trie.root, visit, board, hashSet, words.length);
       }
     }
     return new ArrayList<>(hashSet);
  }
  public void DFS(int row, int col, Node node, boolean[][] visit,
                  char[][] board, HashSet<String> hashSet, int max) {
    Node cur = node;
    if (row < 0 || row >= ROW || col < 0 || col >= COL) {
      return;
    }
    if (visit[row][col]) {
      return;
    }
    char ch = board[row][col];
    if (!cur.Children.containsKey(ch)) {
      return;
    }
    visit[row][col] = true;
    cur = cur.Children.get(ch);
    if (cur.isWord) {
      hashSet.add(cur.Word);
    }
    if (hashSet.size() == max) {
      return;
    }
    DFS(row-1, col, cur, visit, board, hashSet, max);
    DFS(row+1, col, cur, visit, board, hashSet, max);
    DFS(row, col-1, cur, visit, board, hashSet, max);
    DFS(row, col+1, cur, visit, board, hashSet, max);
    visit[row][col] = false;
  }
}
