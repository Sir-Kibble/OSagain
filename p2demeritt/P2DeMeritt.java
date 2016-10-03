package p2demeritt;
import java.util.Arrays;
import java.util.Random;
public class P2DeMeritt {
    public static void main(String[] args) {
        Random R = new Random();
        Thread t1, t2, t3;
        Sorter S1, S2;
        Merger M;
        int[] ints = new int[R.nextInt(11)+10];
        int[] split1 = new int[ints.length/2];
        int[] split2 = new int[ints.length - ints.length/2];
        //populating array
        for(int x = 0; x < ints.length; x++){
            ints[x] = R.nextInt(51);
        }//end for
        for(int x = 0; x < ints.length; x++){
            if(x < ints.length/2)
                split1[x] = ints[x];
            else
                split2[x - ints.length/2] = ints[x];
        }//end for
        System.out.print("\ninitial int array : ");
        for(int x = 0; x < ints.length; x++)
        System.out.print(" "+ints[x]);
        System.out.print("\nunsorted first 1/2 : ");
        for(int x = 0; x < split1.length; x++)
        System.out.print(" "+split1[x]);
      
        System.out.print("\nunsorted second 1/2 : ");
        for(int x = 0; x < split2.length; x++)
        System.out.print(" "+split2[x]);
        //System.out.print("\n");
        S1 = new Sorter(split1);
        S2 = new Sorter(split2);
        M = new Merger(split1,split2, ints.length);
        t1 = new Thread(S1);
        t2 = new Thread(S2);
        t3 = new Thread(M);
        t1.run();
        t2.run();
        t3.run();
        split1 = S1.getInts();
        split2 = S2.getInts();
        System.out.print("\n sorted first 1/2 : ");
        for(int x = 0; x < split1.length; x++)
        System.out.print(" "+split1[x]);
      
        System.out.print("\nsorted 2nd 1/2 : ");
        for(int x = 0; x < split2.length; x++)
        System.out.print(" "+split2[x]);
        System.out.println();
        /*for(int x = 0; x < ints.length; x++){
            if(x < ints.length/2)
                ints[x] = split1[x];
            else
                ints[x] = split2[x - ints.length/2];
        }//end for*/
        ints = M.getInts();
        System.out.print("Final sorted array : ");
        //Arrays.sort(ints);
        for(int x = 0; x < ints.length; x++)
        System.out.print(" "+ints[x]);
    }//end main
}//end p2demeritt