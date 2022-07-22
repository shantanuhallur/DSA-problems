class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int s = 0;
        int e = people.length-1;
        
        int boats = 0;
        while(s<e){
            if(people[s]+people[e]<=limit){
                boats++;
                s++; 
                e--;
            }
            else{
                e--;
                boats++;
            }
        }
        
        if(s==e){
            boats += 1;
        }
        return boats;
    }
}