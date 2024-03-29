class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        
        for(int i=0;i<image.length;i++){
            int low =0;
            int high=image[0].length-1;
            while(low<=high){
                if(image[i][low]==image[i][high]){
                    image[i][high] = 1 - image[i][high]; //trick to Flip 1s to 0s and 
                    image[i][low] = image[i][high]; //0s to 1s.
                }
                low++;
                high--;
            }
        }
        return image;
    }
}