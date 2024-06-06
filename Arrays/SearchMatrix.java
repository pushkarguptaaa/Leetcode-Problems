package Arrays;

public class SearchMatrix {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n= matrix.length;
        int m= matrix[0].length;

        for(int i=0; i<n; i++){
            if(target>= matrix[i][0] && target<= matrix[i][m-1]){
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }

    public boolean binarySearch(int [] row, int target){
        int n= row.length;
        int left= 0;
        int right= n-1;

        while(left<=right){
            int mid= (left+right)/2;
            if(row[mid]== target) return true;
            else if(row[mid]>target) right= mid-1;
            else left= mid+1;
        }
        return false;
    }
}

class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n= matrix.length;
        int m= matrix[0].length;
        int left= 0;
        int right= (n*m)-1;

        while(left<=right){
            int mid= (left+right)/2;
            int row= mid/m, col= mid%m;
            if(matrix[row][col]==target) return true;
            else if(matrix[row][col]>target) right= mid-1;
            else left= mid+1;
        }
        return false;
    }
}
