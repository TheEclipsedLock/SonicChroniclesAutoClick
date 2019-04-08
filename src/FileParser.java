//The website used was:
//https://www.mathsisfun.com/combinatorics/combinations-permutations-calculator.html
//With 4 types to choose from (n)
//With a number chosen being 8 (r)
//With order being important
//With repetition being allowed
//65536 permutations were created with the formula n^r
//The list being
//a,b,x,y
//***Make sure the list doesn't begin with a space!!***
//There are 57 inputs per "line"

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {
    //Allows us to read the input file.
    BufferedReader buffReader;

    //Holds the tokens from the file.
    String[] inputTokens;

    //Reference to the autoClicker object
    AutoClick autoClick;

    //Initializes the buffReader object and utilizes the reference to the autoClick object.
    public FileParser(AutoClick autoClick) throws FileNotFoundException {
        this.autoClick = autoClick;
        buffReader = new BufferedReader(new FileReader("src/small-input.txt"));
    }

    public void buttonPresses() {
        for (String token : inputTokens) {
            String tempButtonCombo = token;
            for (int charIndex = 0; charIndex < tempButtonCombo.length(); charIndex++) {
                char button = tempButtonCombo.charAt(charIndex);
                switch (button) {
                    case 'a':
                        autoClick.a_press();
                        break;
                    case 'b':
                        autoClick.b_press();
                        break;
                    case 'x':
                        autoClick.x_press();
                        break;
                    case 'y':
                        autoClick.y_press();
                        break;
                }
            }
            //System.out.println(token);
            autoClick.waiting();
        }
    }

    //Enhanced For Loop to print the tokens.
    public void printTokens() {
        for (String token : inputTokens) {
            System.out.println(token);
        }
    }

    //Parses the input file into button combination tokens.
    public void parseInitialFile() throws IOException {
        String line;

        //This first while loop parses the file, however, the input is
        //a single, long line of input taken from the website at the top
        //of this file.
        //(Maybe not the best practice, but it definitely works.)
        //As we read the single, long input line, it is split up
        //into 65536 different tokens.
        while ((line = buffReader.readLine()) != null) {
            //System.out.println(line);
            inputTokens = line.split("\\s+");
        }

        //Output should be 65536
        System.out.println("The number of (button combination) tokens in the file is: " + inputTokens.length);
        //printTokens();

        String temp;

        //This loop removes the curly braces and commas to get just the button combinations we need.
        for (int x = 0; x < inputTokens.length; x++) {
            temp = inputTokens[x].substring(1, inputTokens[x].length() - 1);
            inputTokens[x] = temp.replace(",", "");

            //However, we already know the codes for Baki, Fimbley, Pooki, and Stugs.
            //It would be very inconvenient to have their codes be inputted since once a valid
            //viral chao input code is entered, we have to stop, exit, and re-enter the chao garden.
            //This way, we don't have to since we are looking for the one code that lets us get Farfinkle.
            //So, technically, we are testing for the remaining 65533 other combinations.
            if (inputTokens[x].equals("babybaby") || inputTokens[x].equals("aaxbybax") || inputTokens[x].equals("baxyabyx") || inputTokens[x].equals("xxybbayx")) {
                inputTokens[x] = "aaaaaaaa";
            }
        }
    }
}
