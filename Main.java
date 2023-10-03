import java.sql.SQLSyntaxErrorException;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.lang.*;

/*
***Steps for project***
1. Develop program that asks the user to input a U.S. state capital.
2. When receive input, report whether the users input is correct.
3. Store all states and capitals in a 2D array, ordered alphabetically by state.
4. Display the current list before it is sorted.
5. Use a bubble sort to sort the content alphabetically by capital.
6. Prompt the user to enter answers for all the state capitals, then display the total count correct. (Should not be case-sensitive)
7. Revise to store the pairs of each state and its capital in a Map using HashMap function.
8. Display content of the map, then use a TreeMap class to sort the map while using a Binary Search tree for storage.
9. Prompt the user to enter a state, and it should then display the capital for the state.
*/
public class Main {
    public static void main(String[] args) {

        String[][] fiftyStates = {
                {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho",
                        "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi",
                        "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma",
                        "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"},

                {"Montgomery", "Juneau", "Phoenix", "Little Rock", "Sacramento", "Denver", "Hartford", "Dover", "Tallahassee", "Atlanta", "Honolulu", "Boise", "Springfield",
                        "Indianapolis", "Des Moines", "Topeka", "Frankfort", "Baton Rouge", "Augusta", "Annapolis", "Boston", "Lansing", "Saint Paul", "Jackson", "Jefferson City", "Helena",
                        "Lincoln", "Carson City", "Concord", "Trenton", "Santa Fe", "Albany", "Raleigh", "Bismarck", "Columbus", "Oklahoma City", "Salem", "Harrisburg", "Providence", "Columbia",
                        "Pierre", "Nashville", "Austin", "Salt Lake City", "Montpelier", "Richmond", "Olympia", "Charleston", "Madison", "Cheyenne"
        }

        };
        // create scanner

        Scanner newScanner = new Scanner(System.in);
        System.out.println("Please enter one of the 50 U.S. State Capitals: ");
        String userCapital = newScanner.nextLine();
        boolean match = false;


        String[] cities = fiftyStates[1];
        String[] states = fiftyStates[0];
        for (String city : cities) {
            if (city.equalsIgnoreCase(userCapital)) {
                System.out.println("That is a correct U.S. capital!");
                match = true;
                break;
            }
        }
        if (match) {
            System.out.println("Yes that is a correct capital!");
        }
        else {
            System.out.println("Sorry, this is not a correct guess, please try again.");
        }
        for (int i = 0; i < 50; i++) {
            System.out.println("The capital of " +fiftyStates[0][i]+" is "+fiftyStates[1][i]);
        }

        boolean sorted = false;

        //begin the bubble sort and swaps... entire bubble sort, sorted array by capitals

        for (int i = 0; i < fiftyStates[0].length; i++) {
            for (int j = i+1; j < fiftyStates[0].length; j++) {
                String city;
                String state;

                if (fiftyStates[1][i].compareTo(fiftyStates[1][j])>0) {
                    city = fiftyStates[1][i];
                    fiftyStates[1][i] = fiftyStates[1][j];
                    fiftyStates[1][j] = city;

                    state = fiftyStates[0][i];
                    fiftyStates[0][i] = fiftyStates[0][j];
                    fiftyStates[0][j] = state;
                }
            }
        }


        System.out.println("Now we are going to play a game that involves guessing the rest of the 50 states capitals.");
        System.out.println("You will be prompted to guess one of the 50 U.S. state capitals.");
        System.out.println("Guess as many capitals as you can, and when you are done, type in: 'quit'");
        System.out.println("And this will terminate the program.");
        System.out.println("Please enter your guesses now: ");

        /*the steps below will capture the guesses that the user inputs, and will same them in an array called
        userGuesses. When the user types in "quit" this portion of the program is terminated.
         */

        boolean whenEnded = false;
        Scanner guessScanner = new Scanner(System.in);
        ArrayList<String> userGuesses = new ArrayList<>();
        while (!whenEnded) {
            String userInput = guessScanner.nextLine();
            if (userInput.equalsIgnoreCase("quit")) {
                System.out.println("The program will proceed to the next step.");
                whenEnded = true;
            }
            else {
                userGuesses.add(userInput);
            }
        }
        int userCorrectGuesses = 0;

        for (String correct : userGuesses) {
            for (String city : cities) {
                if (city.equalsIgnoreCase(correct)) {
                    userCorrectGuesses++;
                }
            }
        }
        System.out.println("You got "+userCorrectGuesses+" guesses correct!");

        HashMap<String, String> statesAndCapitals = new HashMap<>(fiftyStates[0].length);
        for (int i = 0; i < fiftyStates[0].length; i++) {
            statesAndCapitals.put(fiftyStates[0][i], fiftyStates[1][i]);
        }
        for (String unlocker : statesAndCapitals.keySet()) {
            System.out.println("The capital of "+unlocker+" is "+statesAndCapitals.get(unlocker));
        }
        TreeMap<String, String> sortedStatesAndCapitals = new TreeMap<>(statesAndCapitals);

        System.out.println("Enter a state and the program will print the corresponding capital.");
        System.out.println("If you want to end the program, enter: 'quit'");

        boolean endProgram = false;

        while (!endProgram) {
            System.out.println("Enter a state: ");
            String userState = guessScanner.nextLine();
            if (userState.equalsIgnoreCase("quit")) {
                System.out.println("Thank you for playing the game!");
                endProgram = true;
                continue;
            }
            if (sortedStatesAndCapitals.containsKey(userState)) {
                System.out.println("The capital of "+userState+" is "+sortedStatesAndCapitals.get(userState));
            }
            else {
                System.out.println("Sorry, I do not recognize that state, please try again!");
            }
        }
    }
}











