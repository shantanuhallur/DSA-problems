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
        if(root==null) return null;
        
        Node croot = new Node(root.val);
        croot.children = new ArrayList<>();
        int size = root.children.size();
        for(int i=0;i<size;i++) {
            if(root.children.get(i)!=null)croot.children.add(cloneTree(root.children.get(i))); 
            //else croot.children.add(null);
        }     
        
        return croot;
    }
}