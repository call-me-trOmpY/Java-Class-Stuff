import java.io.*;
import java.util.*;
import java.text.*;


public class PigLatinClient
{


	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		String test = "The quick brown fox jumps over the lazy dog";
		while (! test.equalsIgnoreCase("quit"))
		{
			System.out.println(PigLatin.translateSentence(test));
			System.out.println("Enter a sentence to translated ('quit' to exit)");
			test = input.nextLine();
		}
	}


}