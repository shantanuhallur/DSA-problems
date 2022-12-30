/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node cloneTree(Node root) {
        //Basce Case
        if(root==null) return null;
    
        Node cloneRoot = new Node(root.val);
        cloneRoot.children = new ArrayList<>();
        int size = root.children.size();
        //Traverse on every child of this root to clone
        for(int i=0;i<size;i++) {
            if(root.children.get(i)!=null) cloneRoot.children.add(cloneTree(root.children.get(i)));
        }
        
        return cloneRoot;
    }
}