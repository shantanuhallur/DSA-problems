class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        //difference of Edges( Outdegree - Indegree);
        //root special case diff=1;
        int diff = 1;
        for(String node : nodes) {
            if(--diff<0)return false;
            if(!node.equals("#")) diff+=2;
        }
        return diff==0;
    }
}