/**
 *
 * @author m. dabney
 */
public class PigLatin
{

    private static final String VOWELS = "aeiou";


    public static String translateSentence(String sentence)
    {
        int knt = 0;
        String[] words = sentence.split("\\s+"); // splits by whitespace
        StringBuilder newSentence = new StringBuilder("");
        for (String word : words)
        {
            newSentence.append(translate(word));
            knt++;
            if (knt < words.length )
            {
                newSentence.append(" ");
            }
        }
        try
        {
            Thread.sleep(3);  // introduce some phony lag time
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        return newSentence.toString();

    }



    public static String translate(String word)
    {

        int start = 0; // start index of word
        int firstVowel = 0;
        int end = word.length(); // end index of word
        StringBuilder extraStuff = new StringBuilder("");
        // if last char is not a letter, consider it punctuation and save it off
        if (! Character.isLetter(word.charAt(end - 1)) )
        {
            extraStuff.append(word.charAt(end - 1));
            end = end - 1;
        }
        for(int i = 0; i < end; i++) // loop over length of word
        {

            char c = Character.toLowerCase(word.charAt(i)); // char of word at i, lower cased
            if(VOWELS.indexOf(c) > -1 ) // if this char is a vowel
            {
                firstVowel = i;
                break; // stop looping
            }
        }
        if(start != firstVowel)  // if start is not equal to firstVowel, we caught a vowel.
        {
            String startString = word.substring(firstVowel, end);
            String endString = word.substring(start, firstVowel) + "ay";
            word = startString + endString + extraStuff.toString();
        }
        else  //couldn't find a vowel, return original + "ay"
        {
            word = word + "ay" + extraStuff.toString();
        }
        return word;
    }

}