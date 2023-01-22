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
   
    void serialize(TreeNode node,StringBuilder sb) {
        if(node==null) {
            sb.append("#,");
            return;
        }
        
        sb.append(node.val + ",");
        serialize(node.left,sb);
        serialize(node.right,sb);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb =new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }
    int st =0;
    TreeNode buildTree(String [] arr,int end) {
        if(st>end) return null;
        if(arr[st].equals("#")) {
            st++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[st++]));
        root.left = buildTree(arr,end);
        root.right =buildTree(arr,end);
            
        return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        ArrayList<String> ans = new ArrayList<>(Arrays.asList(data.split(",")));
        String[] arr = new String[ans.size()];
        int j=0;
        for(String i:ans) {
            arr[j++] = i; 
        }
        TreeNode root = buildTree(arr,ans.size()-1);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;