class Solution {
    public int reachNumber(int target) {
      target = Math.abs(target);
        int ans = 0;
        int x = 0;
        while(true){
            int range = x*(x+1)/2;
            if(range>= target && target%2==range%2){
                break;
            }
            x++;
        }
        return x;
    }
}