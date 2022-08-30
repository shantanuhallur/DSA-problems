class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int line_width = 100;
        int line = 1;
        int curr_pointer=0;
        for(char ch:s.toCharArray()){
            if(curr_pointer + widths[ch-'a']<=100){
                 curr_pointer += widths[ch-'a'];
            }
            else{
                line++;
                curr_pointer = 0;
                curr_pointer += widths[ch-'a'];
            }
        }
        int[] ans = new int[2];
        ans[0] = line;
        ans[1] = curr_pointer;
        return ans;
    }
}