/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        //Create stack and return answer variables.
        LinkedList<Integer> ans = new LinkedList<>();
        //Handling root == null case
        if(root==null) return ans;
        // add in stack root 
        LinkedList<Node> st = new LinkedList<>();
        st.addLast(root);
        // keep adding removenode children in stack
        while(st.size()!=0) {
            Node removeN = st.removeLast();
            
            for(Node child : removeN.children) {
                st.addLast(child);
            }
            // keep adding remove Node at 0th idx in our ans;
            ans.addFirst(removeN.val);
        }
        
        return ans;
    }
}