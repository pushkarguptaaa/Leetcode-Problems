package Arrays;

public class FloodFill {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;

        int old = image[sr][sc];
        image[sr][sc] = color;

        helper(image, sr, sc, old, color);

        return image;
    }

    void helper(int[][] image, int sr, int sc, int old, int color){
        int[][] adj = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };

        int n = image.length;
        int m = image[0].length;

        for(int[] cell: adj){
            int newsr = sr + cell[0];
            int newsc = sc + cell[1];

            if(newsr >= 0 && newsr < n && newsc >= 0 && newsc < m && image[newsr][newsc] == old){
                image[newsr][newsc] = color;
                helper(image, newsr, newsc, old, color);
            }
        }
    }
}
