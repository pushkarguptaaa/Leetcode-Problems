package GreedyAlgorithm;

import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {
        
    }
}


class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class ItemComparator implements Comparator<Item>{
    @Override
    public int compare(Item a, Item b){
        double x= (double)a.value/(double)a.weight;
        double y= (double)b.value/(double)b.weight;
        if(x<y) return 1;
        else if(x>y) return -1;
        else return 0;
    }
}

class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item arr[], int n) {
        Arrays.sort(arr, new ItemComparator());
        double currWeight= 0;
        double maxValue= 0;
        
        for(int i=0; i<n; i++){
            if(currWeight+arr[i].weight<=w){
                currWeight+= arr[i].weight;
                maxValue+= arr[i].value;
            }
            else{
                double remain= w-currWeight;
                maxValue+= ((double)arr[i].value/(double)arr[i].weight)*remain;
                break;
            }
        }
        return maxValue;
    }
}
