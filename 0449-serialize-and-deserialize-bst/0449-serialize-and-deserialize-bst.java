/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    public void serialize(TreeNode node,StringBuilder sb) {
        if(node==null){
            sb.append("#"+",");
            return;  
        } 
        sb.append(node.val+",");
        serialize(node.left,sb);
        serialize(node.right,sb);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }
    int idx = 0;
    TreeNode getTree(String[] arr,int e) {
        if(idx>e) return null;
        if(arr[idx].equals("#"))  {
            idx++;
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(arr[idx++]));
        root.left = getTree(arr,e);
        root.right = getTree(arr,e);
        
        return root;
    }
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        if(arr.length==0) return null;
        TreeNode root = getTree(arr,arr.length-1);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;