package Tries;

public class ImplementTrie2 {
    class Node{
        Node[] links;
        int cntend;
        int cntpre;

        Node(){
            links = new Node[26];
            cntend = 0;
            cntpre = 0;
        }

        boolean contains(char ch){
            return links[ch - 'a'] != null;
        }

        void put(char ch, Node node){
            links[ch - 'a'] = node;
        }

        Node get(char ch){
            return links[ch - 'a'];
        }

        void incend(){
            cntend++;
        }

        void decend(){
            cntend--;
        }

        void incpre(){
            cntpre++;
        }

        void decpre(){
            cntpre--;
        }
    }

    Node root;

    public ImplementTrie2() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;

        for(int i = 0; i < word.length(); i++){
            if(!node.contains(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
            node.incpre();
        }
        node.incend();
    }

    public int countWordsEqualTo(String word) {
        Node node = root;

        for(int i = 0; i < word.length(); i++){
            if(node.contains(word.charAt(i))){
                node = node.get(word.charAt(i));
            }
            else return 0;
        }
        return node.cntend;
    }

    public int countWordsStartingWith(String word) {
        Node node = root;

        for(int i = 0; i < word.length(); i++){
            if(node.contains(word.charAt(i))){
                node = node.get(word.charAt(i));
            }
            else return 0;
        }
        return node.cntpre;
    }

    public void erase(String word) {
        Node node = root;

        for(int i = 0; i < word.length(); i++){
            if(node.contains(word.charAt(i))){
                node = node.get(word.charAt(i));
            }
            node.decpre();
        }
        node.decend();
    }
}
