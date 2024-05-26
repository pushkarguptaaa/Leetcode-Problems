package Arrays;
import java.util.*;

public class pascalTriangle {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans= new ArrayList<>();

        for(int row=1; row<=numRows; row++){
            ans.add(generateRow(row));
        }

        return ans;
    }

    public List<Integer> generateRow(int row){
        List<Integer> ansRow= new ArrayList<>();
        long ans= 1;
        ansRow.add(1);

        for(int col=1; col<row; col++){
            ans= ans*(row-col);
            ans= ans/col;
            ansRow.add((int)ans);
        }
        return ansRow;
    }

}


