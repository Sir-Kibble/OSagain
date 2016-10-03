package p2demeritt;

import java.util.Arrays;

public class Merger implements Runnable{
    private int[] a,b,c;
    int length;
    
    public Merger(int[] aa, int[] bb, int x){
        a = aa;
        b = bb;
        c = new int[x];
        length = x;
    }//end constructor
    
    @Override
    public void run() {
        for(int x = 0; x < length; x++){
            if(x < length/2)
                c[x] = a[x];
            else
                c[x] = b[x - length/2];
        }//end for
        Arrays.sort(c);
    }//end run
    public int[] getInts(){
        return c;
    }//end ints
}