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
    public List<List<Integer>> levelOrder(Node root) {
        //Base Case
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(root);
        //LEVEL ORDER TRAVERSAL
        while(que.size()!=0) {
            //size & levelAns -> list 
            int size = que.size();
            List<Integer> levelAns = new ArrayList<>();
            while(size-->0) {
                Node removeN = que.removeFirst();
                
                for(Node child : removeN.children) {
                    que.addLast(child);
                }
                levelAns.add(removeN.val);
            }
            ans.add(levelAns);
        }
        return ans;
    }
}