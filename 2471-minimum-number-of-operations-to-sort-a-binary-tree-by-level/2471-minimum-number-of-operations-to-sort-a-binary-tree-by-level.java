/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
//     public class Pair implements Comparable<Pair> {
//         int val;
//         int idx;
        
//         Pair(int val, int idx) {
//             this.val = val;
//             this.idx = idx;
//         }
        
//         @Override
//         public int compareTo(Pair o) {
//             return this.val - o.val;
//         }
//     }
    
    public class Pair {
        int val;
        int idx;
        
        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
    
    public int getMoves(int[] list) {
        int n = list.length;
        Pair[] arr = new Pair[n];
        int totalCyclesLen = 0;
        for(int i=0;i<n;i++) arr[i] = new Pair(list[i],i);
        
        Arrays.sort(arr,(a,b)->{
            return a.val-b.val;
        });
        
        boolean[] vis = new boolean[n];
        
        for(int i=0;i<n;i++) {
           if(arr[i].idx == i || vis[i] == true) continue;
            int j = i;
            int cycleC = 0;
            while(vis[j] == false) {
                vis[j] = true;
                cycleC++;
                j = arr[j].idx;
            }
            totalCyclesLen += cycleC - 1;
        }
        return totalCyclesLen;
    }
    
    public int minimumOperations(TreeNode root) {
        int ansMoves = 0;
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        while(que.size()!=0) {
            int size = que.size();
            int i = 0;
            int[] list = new int[size];
            while(size-->0) {
                TreeNode removeN = que.removeFirst();
                list[i++] = removeN.val;
                if(removeN.left != null) que.addLast(removeN.left);
                
                if(removeN.right != null) que.addLast(removeN.right);
            }
            
            ansMoves += getMoves(list);
        }
        return ansMoves;
    }
}