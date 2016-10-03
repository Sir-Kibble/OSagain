package p2demeritt;

import java.util.Arrays;

public class Sorter implements Runnable{
    private int[] ints;
    public Sorter(int[] intArray){
        ints = intArray;
    }//end constructor
    
    public int[] getInts(){
        return ints;
    }//end getInts
    
    @Override
    public void run() {
        Arrays.sort(ints);
        
    }//end run
}//end Runnable