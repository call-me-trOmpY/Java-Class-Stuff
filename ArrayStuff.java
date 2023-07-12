import java.util.*;
import java.io.*;
import java.text.*;
import java.lang.*;
/*


*/
public class ArrayStuff
{
    public static void main(String[] args)
    {


        // two ways to declare and populate Arrays
        String [] stooges = {"Moe", "Larry", "Curly" };

        String[] dnames = new String[8];
        dnames[0] = new String("Sneezy");
        dnames[1] = new String("Sleepy");
        dnames[2] = new String("Grumpy");
        dnames[3] = new String("Dopey");
        dnames[4] = new String("Happy");
        dnames[5] = new String("Doc");
        dnames[6] = new String("Bashful");

       System.out.println("Total stooges = "+stooges.length);

       System.out.println("The 0th stooge is "+stooges[0]);
       System.out.println("The 2nd stooge is "+stooges[2]);


       // note that the length is number of elements, not number of populated elements
       System.out.println("The length of the dwarf array is "+dnames.length);

       System.out.println("The 6th dwarf is "+dnames[6]);
       dnames[6] = new String("Chuck");
       System.out.println("NOW, The 6th dwarf is "+dnames[6]);


    }



}

