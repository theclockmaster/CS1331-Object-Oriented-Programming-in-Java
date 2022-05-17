/* Hello, and welcome! Please make sure to read all parts carefully.

        For homework 02, you will be creating a calculator that can perform the following operations: add, subtract, multiply, divide, and alphabetize. The operations work as follows:

        Add - takes two integers, adds them and prints out the result
        Subtract - takes two integers, subtracts the second entered integer from the first and prints out the result
        Multiply - takes two doubles, multiplies them and prints out the result to two decimal places
        Divide - takes two doubles, divides them and prints out the result to two decimal places
        Alphabetize - takes two Strings of only letters, and tells which word comes before the alphabetically
        Your program will be named Calculator.java. It should work as follows:

        Print out the list of operations for the user.
        Prompt the user to enter an operation. If at any point an invalid input is given, the program should terminate.
        Perform the chosen operation and print the correct output.
        If the user is performing an add/subtract operation, prompt the user to enter two integers.
        If the user is performing a multiply/divide operation, prompt the user to enter two doubles.
        If the user is performing an alphabetize operation, prompt the user to enter two Strings NOT integers.
        The program should end after the operation is performed.
        Note that 0 should not be in the denominator if you are dividing. If a 0 is in the denominator, terminate your program. For the multiply and divide operations, format your output using printf.

        Your program is required to have at least one switch statement and one if/else statement.

        For the alphabetize operation, you will be using a method that compares two strings lexicographically, and returns an integer depending on which String is larger. If a 0 is returned, both Strings are lexicographically equal. A positive integer is returned if the first string is lexicographically greater than the second string, or else the result would be negative.

        Hint: You'll likely use one of the String methods that takes a substring of a String. Refer to the String API if needed.

        When prompting for integers, doubles, or Strings, a single space will serve as a divider between the two inputs. Remember that when performing multiply/divide operations on doubles, the answer should only include two numbers after the decimal point.

        Example Outputs. User input is bolded. Please make sure to follow the exact formatting as shown in the pdf.

        List of operations: add, subtract, multiply, divide, and alphabetize.
        Enter an operation: add
        Enter two integers: 3 4
        Answer: 7
        List of operations: add, subtract, multiply, divide, and alphabetize.
        Enter an operation: subtract
        Enter two integers: 5 8
        Answer: -3

        List of operations: add, subtract, multiply, divide, and alphabetize.
        Enter an operation: multiply
        Enter two doubles: 3.561 7.63
        Answer: 27.17
        List of operations: add, subtract, multiply, divide, and alphabetize.
        Enter an operation: divide
        Enter two doubles: 12.0 3
        Answer: 4.00
        List of operations: add, subtract, multiply, divide, and alphabetize.`
        Enter an operation:` alphabetize
        Enter two Strings:` "Hello" "World"
        Answer: Hello comes before World alphabetically.
        Rubric
        [100] Calculator.java
        [10] Prompts user to type in an operation
        [10] Prompts user for two integers for add/subtract operations
        [10] Prompts user for two doubles for multiply/divide operations
        [10] Prompts user for two Strings for compare operation
        [10] Uses at least one switch case and if/else statement
        [30] Prints calculation results correctly
        [10] Prints multiplication and division results correctly with two decimal places using printf
        [10] Prints add and subtract results correctly in int
        [10] Prints compareTo results correctly
        [20] Terminates when incorrect input is provided
        [10] Terminates when no invalid operation is put
        [10] Terminates when 0 is in the denominator
        Allowed Imports
        To prevent trivialization of the assignment, you may only import java.util.Scanner.

        Feature Restrictions
        There are a few features and methods in Java that overly simplify the concepts we are trying to teach or break our auto grader. For that reason, do not use any of the following in your final submission:

        var (the reserved keyword)
        System.exit
        Turn-In Procedure
        Submission
        Calculator.java
        You can submit as many times as you want before the deadline, so feel free to resubmit as you make substantial progress on the homework. We will only grade your last submission.

        Important Notes (Don't Skip)
        Non-compiling files will receive a 0 for all associated rubric items
        Do not submit .class files.
        Test your code in addition to the basic checks on Gradescope
        Submit every file each time you resubmit
        Read the "Allowed Imports" and "Restricted Features" to avoid losing points
        Check on Piazza for all official clarifications */

import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);

        System.out.println("List of operations: add subtract multiply divide alphabetize");
        System.out.println("Enter an operation:");
        String operation = user.nextLine(); //What does the user want the calculator to do?
        operation = operation.toLowerCase(); // case IN-sensitive.

        switch (operation) {
            case "add":
            {
                int x;
                int y;
                System.out.println("Enter two integers: ");
                if (user.hasNextInt()){
                    x = user.nextInt();
                    if (user.hasNextInt()){
                        y = user.nextInt();
                    }
                    else {
                        System.out.println("Invalid input entered. Terminating...");
                        break;
                    }

                } else {
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }
                System.out.println("Answer: "+ (x+y));
                break;
            }
            case "subtract":
            {
                int x;
                int y;
                System.out.println("Enter two integers: ");
                if (user.hasNextInt()){
                    x = user.nextInt();
                    if (user.hasNextInt()){
                        y = user.nextInt();
                    }
                    else {
                        System.out.println("Invalid input entered. Terminating...");
                        break;
                    }

                } else {
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }
                System.out.println("Answer: "+ (x-y));
                break;
            }
            case "multiply":
            {
                System.out.println("Enter two doubles: ");
                double x = user.nextDouble();
                double y = user.nextDouble();
                System.out.printf("Answer: %.2f\n", (x*y));
                break;
            }
            case "divide":
            {
                System.out.println("Enter two doubles: ");
                double x = user.nextDouble();
                double y = user.nextDouble();
                if (y == 0) {
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }
                else
                    System.out.printf("Answer: %.2f\n", (x/y));
                break;
            }
            case "alphabetize":
            {
                System.out.println("Enter two words: ");
                String x = user.next();
                String y = user.next();
                int z = x.compareTo(y);
                if ((z == 0) || ((x.toLowerCase()).equals(y.toLowerCase()))){
                    System.out.println("Answer: Chicken or Egg.");
                }
                else if (z>0)
                {
                    System.out.println("Answer: " + x + " comes after " + y + " alphabetically.");
                }
                else
                {
                    System.out.println("Answer: " + x + " comes before " + y + " alphabetically.");
                }
                break;
            }
            default:
                System.out.println("Invalid input entered. Terminating...");
        }
        user.close();
    }
}

