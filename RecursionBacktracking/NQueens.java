package RecursionBacktracking;

import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans= new ArrayList<>();
        char board[][]= new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j]= '.';
            }
        }
        recHelper(0, board, ans);
        return ans;
    }

    void recHelper(int col, char[][] board, List<List<String>> ans){
        if(col==board.length){
            List<String> res= new ArrayList<>();
            for(int row=0; row<board.length; row++){
                String s= new String(board[row]);
                res.add(s);
            }
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int row=0; row<board.length; row++){
            if(validate(board, row, col)){
                board[row][col]= 'Q';
                recHelper(col+1, board, ans);
                board[row][col]= '.';
            }
        }
    }

    boolean validate(char[][] board, int row, int col){
        int dupRow= row;
        int dupCol= col;

        while(row>=0 && col>=0){
            if(board[row][col]=='Q') return false;
            row--;
            col--;
        }

        row= dupRow;
        col= dupCol;

        while(col>=0){
            if(board[row][col]=='Q') return false;
            col--;
        }

        row= dupRow;
        col= dupCol;

        while(row<board.length && col>=0){
            if(board[row][col]=='Q') return false;
            row++;
            col--;
        }

        return true;
    }
}

class Solution1 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans= new ArrayList<>();
        char board[][]= new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j]= '.';
            }
        }
        int[] lRow= new int[n];
        int[] lowerD= new int[2*n-1];
        int[] upperD= new int[2*n-1];
        recHelper(0, board, ans, lRow, lowerD, upperD);
        return ans;
    }

    void recHelper(int col, char[][] board, List<List<String>> ans, int[] lRow, int[] lowerD, int[] upperD){
        if(col==board.length){
            List<String> res= new ArrayList<>();
            for(int row=0; row<board.length; row++){
                String s= new String(board[row]);
                res.add(s);
            }
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int row=0; row<board.length; row++){
            if(lRow[row]==0 && lowerD[row+col]==0 && upperD[board.length-1+col-row]==0){
                board[row][col]= 'Q';
                lRow[row]= 1;
                lowerD[row+col]= 1;
                upperD[board.length-1+col-row]= 1;
                recHelper(col+1, board, ans, lRow, lowerD, upperD);
                board[row][col]= '.';
                lRow[row]= 0;
                lowerD[row+col]= 0;
                upperD[board.length-1+col-row]= 0;
            }
        }
    }
}
