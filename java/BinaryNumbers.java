/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author tonnyhuey
 */
import java.io.*;
import java.util.Scanner;

public class BinaryNumbers {

    public static String inputString;

    public BinaryNumbers() {}

    public static void main(String[] args) {
        BinaryNumbers object;
        object = new BinaryNumbers(); 
        object.printInfo();
        // Switch the methods to use the console input or the file input
        object.processUserNumbers();
        object.processFileNumbers();
    }

    public static void printInfo() {
        System.out.println("This program reads a binary number from you the  user, validates, evaluates and converts it into it's decimalevaluate.");
    }

    public static void processUserNumbers() {
        // get the User input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the binary number to be converted: ");
        inputString = scanner.next();

        // run validation on the input string and store the result of the boolean
        boolean isStringBinary = validateNumber(inputString);

        // print output messages
        System.out.println("String: " + inputString);

        // check if the number is a binary
        if(isStringBinary){
            System.out.println("Status: valid" );
            // convert the binary to a decimal
            int decimal = evaluateNumber(inputString);
            // print the decimal value message
            System.out.println("decimal value: " + decimal);
        } else {
            System.out.println("Status: invalid" );
        }


    }

    private static boolean validateNumber(String str) {
        // set a test boolean initially to 'false'
        boolean _result = false;

        // validate length
        if (str.length() != 8) {
            _result = false;
            return _result;
        }

        // validate if the characters of the string is a binary (0,1)
        for(int i = 0 ; i < str.length() ; i++){
            char _char = str.charAt(i);
            // check if the char at index is a 0 'or' 1
            if(_char == '0' || _char == '1'){
                _result = true;
            } else {
                _result = false;
            }
        }

        //return the result of the test boolean
        return _result;
    }
    
    public static int evaluateNumber(String strBinary) {
        // Easy way to convert a binary string to decimal with radix 2
        return Integer.parseInt(strBinary, 2);

        // code can be modified to do the binary string --> decimal conversion programmatically
    }

    public static void processFileNumbers() {
        try {
            // get the input file
            File file = new File("/Users/tonnyhuey/NetBeansProjects/JavaApplication1/src/javaapplication1/test.txt");

            // create a new output file
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/tonnyhuey/NetBeansProjects/JavaApplication1/src/javaapplication1/test-output.txt"));

            // initialize scanner
            Scanner sc = new Scanner(file);

            // read all the available contents of the file using scanner
            while (sc.hasNextLine()){

                // get a single line
                String _line = sc.nextLine();

                // run validation on the input string and store the result of the boolean
                boolean isStringBinary = validateNumber(_line);

                // print output messages
                writer.write("String: " + _line + "\n");

                // check if the number is a binary
                if(isStringBinary){
                    writer.write("Status: valid" + "\n");
                    // convert the binary to a decimal
                    int decimal = evaluateNumber(_line);
                    // print the decimal value message
                    writer.write("decimal value: " + decimal + "\n");
                } else {
                    writer.write("Status: invalid" + "\n");
                }
                writer.newLine();
            }

            // close the writable file
            writer.close();

        } catch (FileNotFoundException e) {
            throw new Error(e);
        } catch (IOException e) {
            throw new Error(e);
        }
    }
}
