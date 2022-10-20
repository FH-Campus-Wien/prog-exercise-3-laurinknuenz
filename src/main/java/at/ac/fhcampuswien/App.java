package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {
    // Task 1: One Month Calendar
    public static void oneMonthCalendar(int days, int firstDay) {
        int weekCounter = firstDay - 1;

        for (int j = 1; j <= 3 * (firstDay - 1); j++) {
            System.out.print(" ");
        }
        for (int i = 1; i <= days; i++) {
            System.out.printf("%2d", i);
            System.out.print(" ");
            weekCounter++;
            if (weekCounter == 7) {
                System.out.println();
                weekCounter = 0;
            }
        }
        if (weekCounter != 0) System.out.println();
    }

    // Task 2: Pseudo Random Numbers
    public static long[] lcg(long seed) {
        long[] returnArray = new long[10];
        long m = (long) Math.pow(2, 31);
        long a = 1103515245;
        int c = 12345;

        for (int i = 0; i < 10; i++) {
            returnArray[i] = (a * (i == 0 ? seed : returnArray[i - 1]) + c) % m;
        }
        return returnArray;
    }

    // Task 3: Guessing Game
    public static void guessingGame(int numberToGuess) {
        Scanner scanner = new Scanner(System.in);
        int input;

        for (int i = 1; i <= 10; i++) {
            System.out.printf("Guess number %s: ", i);
            input = scanner.nextInt();

            if (input == numberToGuess) {
                System.out.println("You won wisenheimer!");
                break;
            }
            if (i == 10) System.out.println("You lost! Have you ever heard of divide & conquer?");
            else
                System.out.println("The number AI picked is " + (input < numberToGuess ? "higher " : "lower ") + "than your guess.");
        }
    }

    public static int randomNumberBetweenOneAndHundred() {
        Random rnd = new Random();
        return rnd.nextInt(100) + 1;
    }

    // Task 4: Swap Arrays
    public static boolean swapArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) return false;

        for (int i = 0; i < array1.length; i++) array1[i] += array2[i];
        for (int i = 0; i < array1.length; i++) array2[i] = array1[i] - array2[i];
        for (int i = 0; i < array1.length; i++) array1[i] -= array2[i];

        return true;
    }

    // Task 5: Camel Case
    public static String camelCase(String sentence) {
        char[] charArray = sentence.toCharArray();
        String result = "";
        boolean nextSignCaps = true;

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] >= 65 && charArray[i] <= 90 || charArray[i] >= 97 && charArray[i] <= 122) {
                if (nextSignCaps) {
                    if (charArray[i] >= 97 && charArray[i] <= 122) result += (char) (charArray[i] - 32);
                    else result += (char) charArray[i];
                    nextSignCaps = false;
                } else {
                    if (charArray[i] >= 65 && charArray[i] <= 90) result += (char) (charArray[i] + 32);
                    else result += (char) charArray[i];
                }
            } else if (charArray[i] == 32) nextSignCaps = true;
        }
        return result;
    }

    //Task 6: Check Digit
    public static int checkDigit(int[] inputArray) {
        int productsSum=0;
        int checkDigit;
        for (int i = 0; i < inputArray.length; i++){
            productsSum += inputArray[i] * (i+2);
        }
        checkDigit = 11 - (productsSum % 11);
        if(checkDigit == 10) return 0;
        else if (checkDigit == 11) return 5;
        return checkDigit;
    }

    public static void main(String[] args) {/*
        System.out.println("Task 1: One Month Calendar");
        App.oneMonthCalendar(28, 6);

        System.out.println("Task 2: Pseudo Random Numbers");
        long numbersArray[] = App.lcg(0);
        for (long n : numbersArray) {
            System.out.println(n);
        }

        System.out.println("Task 3: Guessing Game");
        App.guessingGame(randomNumberBetweenOneAndHundred());

        System.out.println("Task 4: Swap Arrays");
        int[] array1 = {1,2,3,4,5};
        int[] array2 ={100,99,60,44,2};
        App.swapArrays(array1, array2);

        System.out.println("Task 5: Camel Case");
        System.out.println(App.camelCase("my naMe isn'T AlicE"));
*/
        System.out.println("Task 6: Check Digit");
        int[] inputArray = {3, 9, 1, 5, 8};
        System.out.println(App.checkDigit(inputArray));
    }
}