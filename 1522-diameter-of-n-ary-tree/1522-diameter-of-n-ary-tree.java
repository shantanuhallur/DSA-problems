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
    public int maxH =0;
    public int findMaxDia(Node node) {
        if(node.children.size() == 0) return 0;
        
        int firstH = -1;
        int secondH = -1;
        for(Node child:node.children) {
            int childH = findMaxDia(child);
            if(childH>=firstH){
                secondH = firstH;
                firstH = childH;
            }
            else if(childH>=secondH) {
                secondH = childH;
            }
            maxH = Math.max(maxH,firstH+secondH+2);
        }
        return firstH+1;
    }
    public int diameter(Node root) {
        findMaxDia(root);
        return maxH;
    }
}