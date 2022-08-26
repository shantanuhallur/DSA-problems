/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> node_vals = new ArrayList<>();
        
        ListNode curr = head;
        while(curr!=null){
            node_vals.add(curr.val);
            curr = curr.next;
        }
        
        int[] output_arr = new int[node_vals.size()];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<node_vals.size();i++){
            while(!st.isEmpty() && node_vals.get(st.peek())<node_vals.get(i)){
                output_arr[st.pop()] = node_vals.get(i);
            }
            st.push(i);
        }
        
        return output_arr;
    }
}