import java.util.Scanner;
import java.io.File;

public class SpellChecker
{
    public static void main(String[] args) throws Exception
    {
        Scanner write = new Scanner(System.in);

        System.out.println("Type a sentence and I will check your spelling/correct words :)");
        String sentence = write.nextLine();
        String[] splitSentence = sentence.split(" ");

        for(int i = 0; i < splitSentence.length; i++)
        {
            Scanner read = new Scanner(new File("dictionary.txt"));

            while(read.hasNextLine())
            {
                String compare = read.nextLine();

                if(compare.equalsIgnoreCase(splitSentence[i]))
                {
                    System.out.println(splitSentence[i] + " : correct");
                }
                else
                {
                    System.out.println(splitSentence[i] + " : incorrect");
                }
            }
        }
    }
}
