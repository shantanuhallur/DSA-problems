class Solution {
    
//     public boolean rootToNPath(TreeNode node, int tar,LinkedList<Integer> ans) {
//         if(node == null) return false
//         if(node.val == target) {
//             ans.addFirst(node);
//             return true;  
//         } 
        
//         boolean foundTarAtLeft = rootToNPath(node.left,tar,ans);
//         if(foundTarAtLeft) ans.addFirst(node.val) return true;
        
//         boolean foundTarAtRight = rootToNPath(node.right,tar,ans)
//         if(foundTarAtRight) ans.addFirst(node.val) return true;
        
//         return false;
//     }
    
    public List<Integer> pathInZigZagTree(int tar) {
        LinkedList<Integer> ans = new LinkedList<>();
        ans.addFirst(tar);
        
        int rEle = 1; 
        int sum = 0;
        while(sum<tar){
            sum+=rEle;
            rEle *=2;
        }
        rEle = rEle/2;
        
        int par = 100;
        while(par>=1){
            int firstEle = rEle;
            int x = sum - tar + firstEle;
            par = x/2;
            if(par!=0)ans.addFirst(par);
            tar = par;
            rEle = rEle/2;
            sum = sum/2;
        }
        return ans;
    }
}