class Solution {
    
    private void PutCharAtBack(char[]arr){
        char temp = arr[0];
        int i=0;
        while(i<arr.length-1){
            arr[i]=arr[i+1];
            i++;
        }
        arr[arr.length-1]=temp;
    }
    
    public String orderlyQueue(String s, int k) {
        char[] arr = s.toCharArray();
        if(k>1){
            Arrays.sort(arr);
            return String.valueOf(arr);
        }
        else{
            String ans = s;
            for(int i=0;i<s.length();i++){
                PutCharAtBack(arr);
                int diff = ans.compareTo(String.valueOf(arr));
                if(diff>0){
                    ans = String.valueOf(arr);
                }
            }
            return ans;
        }
    }
}